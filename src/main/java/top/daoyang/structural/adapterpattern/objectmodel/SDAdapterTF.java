package top.daoyang.structural.adapterpattern.objectmodel;

public class SDAdapterTF implements SDCard {

    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void readSDCard() {
        tfCard.readTFCard();
    }
}