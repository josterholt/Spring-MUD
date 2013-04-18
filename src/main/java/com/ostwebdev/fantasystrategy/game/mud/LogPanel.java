package com.ostwebdev.fantasystrategy.game.mud;

import java.util.ArrayList;
import java.util.Hashtable;

public class LogPanel extends Panel implements IObserver<PlayerRegistry> {

	public void notify(PlayerRegistry playerRegistry, Event event) {
        /*
        ArrayList<Hashtable> players = new ArrayList();
        for(Unit player : playerRegistry.getPlayers()) {
             players.add(player.properties);
        }
         *
         */
        //this.observableData.put("players", players);
        this.observableData.put("num_players", playerRegistry.getPlayers().size());
        this.fireEvent(EventFactory.Update());
    }
}
