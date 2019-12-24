package top.daoyang.behavioral.chainofresponsibilitypattern;

public abstract class HandlerChain {

    private HandlerChain nextHandleChain;

    private int level;

    public HandlerChain(int level) {
        this.level = level;
    }

    public void handlerChain(IRequest request) {
        if (request.getRequestLevel() <= this.level) {
            handlerRequest(request);
        }

        if (nextHandleChain != null)
            nextHandleChain.handlerChain(request);
        else
            System.out.println("---- level " + request.getRequestLevel() + " --- can't be handler ");
    }

    protected abstract void handlerRequest(IRequest request);

    public void setNextHandleChain(HandlerChain handleChain) {
        this.nextHandleChain = handleChain;
    }
}
