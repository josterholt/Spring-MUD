package com.ostwebdev.fantasystrategy.service;

import java.util.Map;

import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.AbstractService;

import com.ostwebdev.fantasystrategy.game.mud.CommandRunner;

public class MUDService extends AbstractService 
{
	public MUDService(BayeuxServer bayeuxServer)
	{
		super(bayeuxServer, "command");
		System.out.println("MUD Started");
		addService("/service/command", "processCommand");
	}
	
	public void processCommand(ServerSession remote, Map<String, Object> data)
	{
		CommandRunner runner = new CommandRunner();
		System.out.println(data.get("action"));
		System.out.println(data.get("target"));
		System.out.println(data.get("parameters"));
		runner.Execute((String) data.get("action"), (String) data.get("target"), (String) data.get("parameters"));
		
		remote.deliver(getServerSession(), "/service/command", (Object) runner.output, null);
	}
}
