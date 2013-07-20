package com.ostwebdev.fantasystrategy.game.mud;

public interface IObserver<E> {
    public void notify(E Observerable, Event event);
}
