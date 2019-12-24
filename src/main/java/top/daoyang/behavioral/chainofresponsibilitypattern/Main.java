package top.daoyang.behavioral.chainofresponsibilitypattern;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<IRequest> requests = new ArrayList<>();
        requests.add(new Request(1, " 1 content"));
        requests.add(new Request(2, " 2 content"));
        requests.add(new Request(3, " 3 content"));

        HandlerChain lowHandlerChain = new LowHandlerChain(1);
        HandlerChain middleHandlerChain = new MiddleHandlerChain(2);
        HandlerChain highHandlerChain = new HighHandlerChain(3);

        lowHandlerChain.setNextHandleChain(middleHandlerChain);
        middleHandlerChain.setNextHandleChain(highHandlerChain);

        for (IRequest request: requests) {
            lowHandlerChain.handlerChain(request);
        }
    }
}
