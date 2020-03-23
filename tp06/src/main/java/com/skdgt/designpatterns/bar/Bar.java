package com.skdgt.designpatterns.bar;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    boolean happyHour;
    List<BarObserver> observers;

    public Bar() {
        this.happyHour = false;
        this.observers = new ArrayList<>();
    }

    void startHappyHour() {
        this.happyHour = true;
        this.notifyObservers();
    }

    void endHappyHour() {
        this.happyHour = false;
        this.notifyObservers();
    }

    public boolean isHappyHour() {
        return happyHour;
    }

    void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }

}
