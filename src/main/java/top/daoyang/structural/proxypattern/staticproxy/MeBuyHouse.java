package top.daoyang.structural.proxypattern.staticproxy;

public class MeBuyHouse implements BuyHouse {

    private String name;

    public MeBuyHouse(String name) {
        this.name = name;
    }

    @Override
    public void buyBigHouse() {
        System.out.println(name + " buying a big house");
    }
}
