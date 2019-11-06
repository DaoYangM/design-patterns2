package top.daoyang.structural.bridgepattern;

public class IPhone extends MobilePhoneAbstract {
    public IPhone(SoftWare softWare) {
        super(softWare);
    }

    @Override
    public void powerOn() {
        System.out.println("power by ios");
    }

    public void nickPicture() {
        System.out.println("Woo nick picture");
    }
}
