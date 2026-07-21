"""OpenAI Responses API proxy that issues Zen requests from a Chrome CDP page."""

import asyncio
import json
import os
import sys
import threading
import time
from collections.abc import Mapping
from typing import Any

import requests
import websocket
from fastapi import FastAPI, HTTPException, Request
from fastapi.responses import JSONResponse, Response

if sys.version_info < (3, 9):
    raise RuntimeError("Python 3.9 or newer is required")

CHROME_DEBUGGER_URL = os.getenv("CHROME_DEBUGGER_URL", "http://127.0.0.1:9222")
CDP_ORIGIN = os.getenv("CDP_ORIGIN", "http://localhost")
ZEN_ENDPOINT = os.getenv("ZEN_ENDPOINT", "https://opencode.ai/zen/v1/responses")
ZEN_TOKEN = os.getenv("ZEN_TOKEN")
REQUEST_TIMEOUT_SECONDS = float(os.getenv("REQUEST_TIMEOUT_SECONDS", "120"))

app = FastAPI(title="Zen CDP Responses Proxy")


class CDPError(RuntimeError):
    """Raised when the Chrome DevTools Protocol request cannot complete."""


class ChromeCDP:
    def __init__(self) -> None:
        self._counter = 0
        self._lock = threading.Lock()
        self._ws: websocket.WebSocket | None = None

    def _connect(self) -> None:
        try:
            response = requests.get(
                f"{CHROME_DEBUGGER_URL.rstrip('/')}/json",
                timeout=REQUEST_TIMEOUT_SECONDS,
            )
        except requests.RequestException as error:
            raise CDPError(f"Cannot reach Chrome DevTools at {CHROME_DEBUGGER_URL}") from error
        try:
            tabs = response.json()
        except ValueError as error:
            raise CDPError("Chrome DevTools returned invalid JSON") from error
        if not isinstance(tabs, list):
            raise CDPError("Chrome DevTools did not return a tab list")

        ws_url = next(
            (
                tab.get("webSocketDebuggerUrl")
                for tab in tabs
                if tab.get("type") == "page" and tab.get("webSocketDebuggerUrl")
            ),
            None,
        )
        if not ws_url:
            raise CDPError("No debuggable Chrome page was found")

        try:
            self._ws = websocket.create_connection(
                ws_url, origin=CDP_ORIGIN, timeout=REQUEST_TIMEOUT_SECONDS
            )
        except websocket.WebSocketException as error:
            raise CDPError("Could not connect to the Chrome CDP WebSocket") from error

    def call(self, method: str, params: Mapping[str, Any] | None = None) -> dict[str, Any]:
        """Run a CDP command and return its response, or raise CDPError on failure."""
        with self._lock:
            if self._ws is None or not self._ws.connected:
                self._connect()

            self._counter += 1
            request_id = self._counter
            message = {"id": request_id, "method": method, "params": params or {}}
            deadline = time.monotonic() + REQUEST_TIMEOUT_SECONDS

            try:
                self._ws.send(json.dumps(message))
                while True:
                    remaining = deadline - time.monotonic()
                    if remaining <= 0:
                        raise CDPError("Chrome CDP command timed out")
                    self._ws.settimeout(remaining)
                    response = json.loads(self._ws.recv())
                    if response.get("id") == request_id:
                        if "error" in response:
                            raise CDPError(response["error"].get("message", "CDP command failed"))
                        return response
            except (websocket.WebSocketException, OSError, json.JSONDecodeError) as error:
                self._ws = None
                raise CDPError("Chrome CDP connection was interrupted") from error


chrome = ChromeCDP()


def zen_request(payload: Mapping[str, Any]) -> dict[str, Any]:
    """Send a Responses payload from Chrome and return its status, type, and body."""
    if not ZEN_TOKEN:
        raise HTTPException(
            status_code=503, detail="ZEN_TOKEN must be set in the proxy environment"
        )

    request_options = {
        "url": ZEN_ENDPOINT,
        "token": ZEN_TOKEN,
        "payload": payload,
    }
    expression = f"""
        (async () => {{
          const options = {json.dumps(request_options)};
          const response = await fetch(options.url, {{
            method: "POST",
            headers: {{
              "Content-Type": "application/json",
              "Authorization": ["Bearer", options.token].join(" ")
            }},
            body: JSON.stringify(options.payload)
          }});
          return {{
            status: response.status,
            contentType: response.headers.get("content-type") || "",
            body: await response.text()
          }};
        }})()
    """
    result = chrome.call(
        "Runtime.evaluate",
        {"expression": expression, "awaitPromise": True, "returnByValue": True},
    )
    evaluation = result.get("result")
    if not isinstance(evaluation, dict):
        raise CDPError("Chrome did not return a Runtime.evaluate result")
    remote_object = evaluation.get("result")
    if not isinstance(remote_object, dict):
        raise CDPError("Chrome did not return a remote result")
    value = remote_object.get("value")
    if not isinstance(value, dict):
        raise CDPError("Chrome did not return a Zen response")
    return value


@app.get("/")
def root() -> dict[str, str]:
    return {"status": "running"}


@app.get("/v1/models")
def models() -> dict[str, Any]:
    return {"object": "list", "data": [{"id": "zen", "object": "model"}]}


@app.post("/v1/responses")
async def responses(request: Request) -> Response:
    try:
        payload = await request.json()
    except json.JSONDecodeError as error:
        raise HTTPException(status_code=400, detail="Request body must be valid JSON") from error

    if not isinstance(payload, dict):
        raise HTTPException(status_code=400, detail="Request body must be a JSON object")

    try:
        upstream = await asyncio.to_thread(zen_request, payload)
    except CDPError as error:
        raise HTTPException(status_code=502, detail=str(error)) from error

    if not isinstance(upstream, dict):
        raise HTTPException(status_code=502, detail="Chrome returned an invalid Zen response")
    body = upstream.get("body")
    status = upstream.get("status")
    content_type = upstream.get("contentType")
    if not isinstance(body, str) or not isinstance(status, int) or not isinstance(content_type, str):
        raise HTTPException(status_code=502, detail="Chrome returned an incomplete Zen response")
    if payload.get("stream"):
        return Response(
            content=body,
            status_code=status,
            media_type=content_type or "text/event-stream",
            headers={"Cache-Control": "no-cache", "X-Accel-Buffering": "no"},
        )

    if content_type.lower().startswith("application/json"):
        try:
            return JSONResponse(content=json.loads(body), status_code=status)
        except json.JSONDecodeError:
            pass
    return Response(content=body, status_code=status, media_type=content_type or "text/plain")


if __name__ == "__main__":
    import uvicorn

    uvicorn.run(app, host="127.0.0.1", port=8080)
