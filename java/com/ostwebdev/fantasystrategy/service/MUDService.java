package com.ostwebdev.fantasystrategy.service;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang.WordUtils;
import org.cometd.bayeux.ChannelId;
import org.cometd.bayeux.server.Authorizer;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ConfigurableServerChannel;
import org.cometd.bayeux.server.LocalSession;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.java.annotation.Configure;
import org.cometd.java.annotation.Listener;
import org.cometd.java.annotation.Session;
import org.cometd.server.authorizer.GrantAuthorizer;

import org.cometd.java.annotation.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ostwebdev.fantasystrategy.domain.User;
import com.ostwebdev.fantasystrategy.game.mud.CommandRunner;

@javax.inject.Named // Tells Spring that this is a bean
@javax.inject.Singleton // Tells Spring that this is a singleton
@Service("mudService")
public class MUDService 
{
	@Inject
	private BayeuxServer bayeux;

	@Session
	private ServerSession serverSession;
	
	@PostConstruct
	public void init()
	{
		System.out.println("MUDService Start");	
	}

	@Configure("/service/command")
	protected void configure(ConfigurableServerChannel channel)
	{
		System.out.println("Configure");
		channel.addAuthorizer(new Authorizer()
		{
			public Result authorize(Operation operation, ChannelId channel,
					ServerSession session, ServerMessage message) {
				User user = (User) bayeux.getContext().getHttpSessionAttribute("user");
				if(user == null)
				{
					return Result.deny("Must be logged in");
				}
				return Result.grant();
			}
			
		});
	    channel.setPersistent(true);
	}
	

	
	@Listener("/service/command")
	public void command(ServerSession remote, Map<String, Object> message)
    {
		Map<String, Object> data = (Map<String, Object>) message.get("data");
		System.out.println("running command");
		User user = (User) bayeux.getContext().getHttpSessionAttribute("user");

		CommandRunner runner = new CommandRunner();
		runner.addAttribute("user",  user);
		
		System.out.println(data.keySet());
		
		System.out.println(data.get("action"));
		System.out.println(data.get("target"));
		System.out.println(data.get("parameters"));

		runner.Execute(WordUtils.capitalize(data.get("action").toString().toLowerCase()), (String) data.get("target"), (String) data.get("parameters"));
				
		remote.deliver(remote, "/service/command", (Object) runner.output, null);
	}
}
