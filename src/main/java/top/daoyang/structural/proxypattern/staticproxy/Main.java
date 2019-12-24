package top.daoyang.structural.proxypattern.staticproxy;

public class Main {

    public static void main(String[] args) {
        BuyHouse agentBuyHouse = new AgentBuyHouse(new MeBuyHouse("Ye"));
        agentBuyHouse.buyBigHouse();
    }
}
