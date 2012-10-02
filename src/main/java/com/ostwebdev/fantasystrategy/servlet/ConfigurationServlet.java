package com.ostwebdev.fantasystrategy.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.cometd.bayeux.server.BayeuxServer;

import com.ostwebdev.fantasystrategy.service.EchoService;
import com.ostwebdev.fantasystrategy.service.MUDService;



public class ConfigurationServlet extends GenericServlet {
	public void init() throws ServletException
	{
		BayeuxServer bayeux = (BayeuxServer)getServletContext().getAttribute(BayeuxServer.ATTRIBUTE);
		new EchoService(bayeux);
		new MUDService(bayeux);
				
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		throw new ServletException();
	}
}
