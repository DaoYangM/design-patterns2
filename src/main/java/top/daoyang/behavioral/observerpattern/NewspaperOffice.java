package top.daoyang.behavioral.observerpattern;


import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class NewspaperOffice implements Publisher {

    private List<Observer> observers;

    public NewspaperOffice() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(null, null);
        }
    }
}
