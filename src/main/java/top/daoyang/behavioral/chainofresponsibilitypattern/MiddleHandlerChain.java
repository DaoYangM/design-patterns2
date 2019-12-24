package top.daoyang.behavioral.chainofresponsibilitypattern;

public class MiddleHandlerChain extends HandlerChain {
    public MiddleHandlerChain(int level) {
        super(level);
    }

    @Override
    protected void handlerRequest(IRequest request) {
        System.out.println("Engineer middle handler request " + request.getContent());
    }
}
