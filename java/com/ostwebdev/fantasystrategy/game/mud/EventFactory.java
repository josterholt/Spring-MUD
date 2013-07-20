package com.ostwebdev.fantasystrategy.game.mud;

public class EventFactory {
    public static Event Update() {
        return new Event("UPDATE");
    }
    public static Event Update(Object value) {
        return new Event("UPDATE", value);
    }
}
