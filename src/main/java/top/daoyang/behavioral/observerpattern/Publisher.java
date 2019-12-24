package top.daoyang.behavioral.observerpattern;

import java.util.Observer;

public interface Publisher {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();
}
