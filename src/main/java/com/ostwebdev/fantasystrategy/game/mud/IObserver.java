package com.ostwebdev.fantasystrategy.game.mud;


import mud.ISubject;

public interface IObserver<E> {
    public void notify(E Observerable, Event event);
}
