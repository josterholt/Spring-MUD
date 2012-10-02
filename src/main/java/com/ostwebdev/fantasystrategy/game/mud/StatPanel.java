
package com.ostwebdev.fantasystrategy.game.mud;

import java.util.ArrayList;
import java.util.HashMap;

public class StatPanel extends Panel implements IObserver<Unit> {
    @Override
    public void notify(Unit unit, Event event) {
        this.observableData.put("hp", unit.properties.get("hp"));
        this.observableData.put("mp", unit.properties.get("mp"));
        this.fireEvent(EventFactory.Update());
    }

}
