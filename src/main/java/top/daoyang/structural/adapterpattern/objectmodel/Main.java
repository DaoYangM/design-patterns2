package top.daoyang.structural.adapterpattern.objectmodel;

public class Main {
    public static void main(String[] args) {
        MacBook macBook = new MacBook();
        macBook.readSDCard(new SDCardImpl());
        macBook.readSDCard(new SDAdapterTF(new TFCardImpl()));
    }
}