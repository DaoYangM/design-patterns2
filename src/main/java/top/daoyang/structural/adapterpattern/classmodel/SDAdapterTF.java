package top.daoyang.structural.adapterpattern.classmodel;

import top.daoyang.structural.adapterpattern.objectmodel.SDCard;
import top.daoyang.structural.adapterpattern.objectmodel.TFCardImpl;

public class SDAdapterTF extends TFCardImpl implements SDCard {

    @Override
    public void readSDCard() {
        readTFCard();
    }
}
