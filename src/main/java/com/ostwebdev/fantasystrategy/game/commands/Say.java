package com.ostwebdev.fantasystrategy.game.commands;

import com.ostwebdev.fantasystrategy.game.mud.ActionResponse;
import com.ostwebdev.fantasystrategy.game.mud.Command;

public class Say implements Command {
	public ActionResponse Execute(String target, String parameters) {
		System.out.println(parameters);
		ActionResponse response = new ActionResponse();
		response.setCallback("say");
		response.setParameter("message", "Player says: " + parameters);
		return response;
	}
}
