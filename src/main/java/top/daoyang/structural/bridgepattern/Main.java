package top.daoyang.structural.bridgepattern;

public class Main {

    public static void main(String[] args) {
        MobilePhoneAbstract iphone = new IPhone(new WeChatSoftWareImpl());

        iphone.powerOn();
        iphone.runSoftWare();
    }
}
