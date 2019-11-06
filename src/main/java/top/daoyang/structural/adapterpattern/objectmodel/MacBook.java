package top.daoyang.structural.adapterpattern.objectmodel;

import java.util.Objects;

public class MacBook implements Computer {
    @Override
    public void readSDCard(SDCard sdCard) {
        Objects.requireNonNull(sdCard).readSDCard();
    }
}