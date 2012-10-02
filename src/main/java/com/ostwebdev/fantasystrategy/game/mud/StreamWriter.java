package com.ostwebdev.fantasystrategy.game.mud;

import com.google.gson.Gson;
import java.util.HashMap;

public class StreamWriter implements IObserver<Panel> {

    @Override
    public void notify(Panel panel, Event event) {
        Gson g = new Gson();
        System.out.println(g.toJson(panel.observableData));
    }

}
