package com.ostwebdev.fantasystrategy.game.commands;

import com.ostwebdev.fantasystrategy.game.mud.ActionResponse;
import com.ostwebdev.fantasystrategy.game.mud.Command;

public class Look implements Command {
	public ActionResponse Execute(String target, String parameters) {
		ActionResponse response = new ActionResponse();
		response.setCallback("say");
		response.setParameter("message", "Player looks: " + parameters);
		return response;
	}
}
