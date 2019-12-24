package top.daoyang.behavioral.chainofresponsibilitypattern;

public class LowHandlerChain extends HandlerChain {

    public LowHandlerChain(int level) {
        super(level);
    }

    @Override
    protected void handlerRequest(IRequest request) {
        System.out.println("Engineer lower handler request " + request.getContent());
    }
}
