package com.ostwebdev.fantasystrategy.game.mud;

public interface Command {
	public ActionResponse Execute(String target, String parameters);
}
