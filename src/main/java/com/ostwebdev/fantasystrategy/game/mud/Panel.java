package com.ostwebdev.fantasystrategy.game.mud;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Panel implements ISubject {
    ArrayList<IObserver> _observers = new ArrayList();
    HashMap observableData = new HashMap();

    public HashMap getData() {
        return this.observableData;
    }

    public void addObserver(IObserver observer) {
        this._observers.add(observer);
    }

    public void fireEvent(Event event) {
        for(IObserver<Object> observer : this._observers) {
            observer.notify(this, event);
        }
    }
}
