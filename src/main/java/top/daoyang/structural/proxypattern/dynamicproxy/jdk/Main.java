package top.daoyang.structural.proxypattern.dynamicproxy.jdk;

import top.daoyang.structural.proxypattern.staticproxy.BuyHouse;
import top.daoyang.structural.proxypattern.staticproxy.MeBuyHouse;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        BuyHouse buyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class},
                new JDKBuyHouseProxy(new MeBuyHouse("Ye")));

        buyHouse.buyBigHouse();
    }
}
