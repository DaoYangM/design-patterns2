package top.daoyang.structural.proxypattern.dynamicproxy.jdk;

import top.daoyang.structural.proxypattern.staticproxy.BuyHouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理 被代理类必须实现接口
 */
public class JDKBuyHouseProxy implements InvocationHandler {

    private BuyHouse buyHouse;

    public JDKBuyHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("buyBigHouse")) {
            System.out.println("JDK proxy first to look big house");

            Object ret = method.invoke(buyHouse, args);

            System.out.println("JDK proxy bad...");

            return ret;
        } else {
            return method.invoke(buyHouse, args);
        }
    }
}
