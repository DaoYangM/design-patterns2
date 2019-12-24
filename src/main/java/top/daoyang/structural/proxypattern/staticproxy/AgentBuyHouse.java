package top.daoyang.structural.proxypattern.staticproxy;

public class AgentBuyHouse implements BuyHouse {

    private BuyHouse buyHouse;

    public AgentBuyHouse(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyBigHouse() {
        System.out.println("Agent first to ask the big house price");
        buyHouse.buyBigHouse();
        System.out.println("Agent works bad...");
    }
}
