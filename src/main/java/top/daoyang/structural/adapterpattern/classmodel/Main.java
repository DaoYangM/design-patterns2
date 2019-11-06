package top.daoyang.structural.adapterpattern.classmodel;

import top.daoyang.structural.adapterpattern.objectmodel.MacBook;
import top.daoyang.structural.adapterpattern.objectmodel.SDCardImpl;

public class Main {

    public static void main(String[] args) {
        MacBook macBook = new MacBook();
        macBook.readSDCard(new SDCardImpl());
        macBook.readSDCard(new SDAdapterTF());
    }
}
