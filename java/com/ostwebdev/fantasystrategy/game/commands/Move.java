package com.ostwebdev.fantasystrategy.game.commands;

import com.ostwebdev.fantasystrategy.game.mud.ActionResponse;
import com.ostwebdev.fantasystrategy.game.mud.Command;

public class Move implements Command {

	public ActionResponse Execute(String target, String parameters) {
		System.out.println(parameters);
		return null;
	}

}
