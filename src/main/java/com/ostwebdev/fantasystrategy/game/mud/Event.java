package com.ostwebdev.fantasystrategy.game.mud;

public class Event {
    public String name;
    public Object value;

    public Event(String name) {
        this.name = name;
        this.value = null;
    }

    public Event(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
