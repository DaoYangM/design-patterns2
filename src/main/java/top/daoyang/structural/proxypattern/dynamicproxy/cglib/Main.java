package top.daoyang.structural.proxypattern.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class Main {

    public static void main(String[] args) {

        MeBuyHouseNoInterface meBuyHouseNoInterface = new MeBuyHouseNoInterface("Ye");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MeBuyHouseNoInterface.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            Object ret;
            if (method.getName().equals("buyHouse")) {
                System.out.println("CgLib proxy first look big house price");
                ret = method.invoke(meBuyHouseNoInterface, objects);
                System.out.println("CgLib proxy work bad...");
            } else {
                ret = method.invoke(meBuyHouseNoInterface, objects);
            }

            return ret;
        });

        MeBuyHouseNoInterface cgbLibProxyMeBuyHouseNoInterface1 = (MeBuyHouseNoInterface) enhancer.create();
        cgbLibProxyMeBuyHouseNoInterface1.buyHouse();
    }
}
