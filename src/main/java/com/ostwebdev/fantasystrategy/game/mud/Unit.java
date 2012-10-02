package com.ostwebdev.fantasystrategy.game.mud;

import java.util.ArrayList;
import java.util.Hashtable;

public class Unit implements ISubject {
    Hashtable attributes = new Hashtable();
    Hashtable properties = new Hashtable();
    ArrayList<IObserver> _observers = new ArrayList();

    @Override
    public void addObserver(IObserver observer) {
        this._observers.add(observer);
    }

    @Override
    public void fireEvent(Event event) {
        for(IObserver observer : this._observers) {
            observer.notify(this, event);
        }
    }

    public Unit() {
        this.attributes.put("str", 5);
        this.attributes.put("int", 5);
        this.attributes.put("wis", 5);
        this.attributes.put("dex", 5);
        this.attributes.put("con", 5);

        this.properties.put("hp", 100);
        this.properties.put("mp", 50);
    }

    public void doDamage(Integer d) {
        Integer hp = (Integer) this.properties.get("hp");
        this.properties.put("hp", hp - d);
        this.fireEvent(EventFactory.Update());
    }
}
