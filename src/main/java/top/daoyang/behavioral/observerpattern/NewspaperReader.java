package top.daoyang.behavioral.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class NewspaperReader implements Observer {

    private String name;

    public NewspaperReader(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " receive a new newspaper");
    }
}
