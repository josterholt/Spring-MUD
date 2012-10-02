package com.ostwebdev.fantasystrategy.game.mud;
import java.util.HashMap;

import com.ostwebdev.fantasystrategy.game.commands.*;

public class CommandRunner {
	public HashMap<String, String> output = new HashMap<String, String>();

	public void Execute(String action, String target, String parameters) {
		Command command;
		try {
			command = (Command) Class.forName("com.ostwebdev.fantasystrategy.game.commands." + action).newInstance();
			ActionResponse response = command.Execute(target, parameters);
			
			output.put("callback", response.getCallback());
			output.put("message", response.getParameter("message"));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
