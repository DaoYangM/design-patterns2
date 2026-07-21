# Zen CDP Responses Proxy

`zen_cdp_proxy.py` exposes an OpenAI-compatible Responses endpoint and performs
the upstream Zen request from a Chrome page through the Chrome DevTools Protocol.
It forwards the entire Responses request body unchanged, so request fields such
as `input`, `instructions`, `tools`, `tool_choice`, `previous_response_id`,
`reasoning`, `metadata`, and `stream` are preserved.

## Run

Start Chrome with remote debugging enabled, then configure the token in the
process environment. Do not place the token in source code.

```sh
python -m pip install -r requirements.txt
ZEN_TOKEN='your-token' python zen_cdp_proxy.py
```

Python 3.9 or newer is required.

Optional variables:

- `CHROME_DEBUGGER_URL` (default `http://127.0.0.1:9222`)
- `CDP_ORIGIN` (default `http://localhost`)
- `ZEN_ENDPOINT` (default `https://opencode.ai/zen/v1/responses`)
- `REQUEST_TIMEOUT_SECONDS` (default `120`)

Configure clients with the HTTP base URL `http://127.0.0.1:8080/v1`, not
`https://` or `ws://`. Using a TLS or WebSocket client against the Uvicorn HTTP
port produces `WARNING: Invalid HTTP request received`.

## API

- `GET /` returns service status.
- `GET /v1/models` exposes the `zen` model.
- `POST /v1/responses` forwards a complete Responses API request and preserves
  the upstream status code and body.

When `stream` is `true`, the upstream Server-Sent Events body is returned as
`text/event-stream`. Chrome CDP must wait for the browser fetch to finish, so
the proxy returns the complete SSE body rather than relaying individual chunks
in real time.
