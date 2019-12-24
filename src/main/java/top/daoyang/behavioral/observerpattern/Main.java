package top.daoyang.behavioral.observerpattern;

import java.util.Observer;

public class Main {

    public static void main(String[] args) {
        Publisher newspaperOffice = new NewspaperOffice();

        Observer ob1 = new NewspaperReader("Ob1");
        Observer ob2 = new NewspaperReader("Ob2");

        newspaperOffice.subscribe(ob1);
        newspaperOffice.subscribe(ob2);

        newspaperOffice.notifyObservers();
    }
}
