
package com.ostwebdev.fantasystrategy.game.mud;

public class StatPanel extends Panel implements IObserver<Unit> {
    public void notify(Unit unit, Event event) {
        this.observableData.put("hp", unit.properties.get("hp"));
        this.observableData.put("mp", unit.properties.get("mp"));
        this.fireEvent(EventFactory.Update());
    }

}
