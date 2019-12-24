package top.daoyang.behavioral.chainofresponsibilitypattern;

public class HighHandlerChain extends HandlerChain {
    public HighHandlerChain(int level) {
        super(level);
    }

    @Override
    protected void handlerRequest(IRequest request) {
        System.out.println("Engineer high handler request " + request.getContent());
    }
}
