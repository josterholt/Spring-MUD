/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ostwebdev.fantasystrategy.game.mud;

import java.util.ArrayList;

public class PlayerRegistry implements ISubject {
    private ArrayList<IObserver> _observers = new ArrayList();
    private ArrayList<Unit> players = new ArrayList();
    private PlayerRegistry() {}

    private static class SingletonHolder
    {
        private final static PlayerRegistry INSTANCE = new PlayerRegistry();

    }

    public static PlayerRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addPlayer(Unit player) {
        this.players.add(player);
        this.fireEvent(EventFactory.Update());
    }

    public ArrayList<Unit> getPlayers() {
        return this.players;
    }

    public Unit getPlayer(Integer n) {
        return this.players.get(n);
    }

    public synchronized void removePlayer(Unit player) {
        this.players.remove(player);
        this.fireEvent(EventFactory.Update());
    }

    @Override
    public void addObserver(IObserver observer) {
        this._observers.add(observer);
    }

    @Override
    public void fireEvent(Event event) {
        for(IObserver<Object> observer : this._observers) {
            observer.notify(this, event);
        }
    }


}
