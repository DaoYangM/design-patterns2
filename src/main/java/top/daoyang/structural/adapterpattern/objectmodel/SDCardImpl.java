package top.daoyang.structural.adapterpattern.objectmodel;

public class SDCardImpl implements SDCard {
    @Override
    public void readSDCard() {
        System.out.println("sd card read");
    }
}
