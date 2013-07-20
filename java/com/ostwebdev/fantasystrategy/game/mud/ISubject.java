package com.ostwebdev.fantasystrategy.game.mud;

public interface ISubject {
    public void addObserver(IObserver observer);
    public void fireEvent(Event event);
}
