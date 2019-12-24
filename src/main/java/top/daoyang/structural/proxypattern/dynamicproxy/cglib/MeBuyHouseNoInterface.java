package top.daoyang.structural.proxypattern.dynamicproxy.cglib;

public class MeBuyHouseNoInterface {

    private String name;

    public MeBuyHouseNoInterface() {
    }

    public MeBuyHouseNoInterface(String name) {
        this.name = name;
    }

    public void buyHouse() {
        System.out.println(name + " buy house¡");
    }
}
