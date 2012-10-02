package com.ostwebdev.fantasystrategy.service;

import java.util.Map;

import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.AbstractService;

public class EchoService extends AbstractService 
{
	public EchoService(BayeuxServer bayeuxServer)
	{
		super(bayeuxServer, "echo");
		System.out.println("test 1234");
		addService("/echo", "processEcho");
	}
	
	public void processEcho(ServerSession remote, Map<String, Object> data)
	{
		remote.deliver(getServerSession(), "/echo", data, null);
	}
}
