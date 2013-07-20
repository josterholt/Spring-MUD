package com.ostwebdev.fantasystrategy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ostwebdev.fantasystrategy.domain.User;
import com.ostwebdev.fantasystrategy.repository.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"user"})
public class HomeController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/dojo", method = RequestMethod.GET) 
	public String dojo(Model model) {
		return "dojo";
	}
	
	@RequestMapping(value = "/cometdfoo", method = RequestMethod.GET) 
	public String cometdfoo(Model model) {
		return "cometdfoo";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		/*
		User u = new User();
		u.setUsername("test2");
		u.setPassword("test2");
		userRepo.save(u);
		System.out.println("Testing");
		*/
		return "login";
	}
	
	@RequestMapping(value = "/fetchuser", method = RequestMethod.GET)
	public String fetchuser(Model Model) {
		System.out.println("Password:");
		User u = userRepo.findByUsername("test2");
		System.out.println(u.getPassword());
		return "home";
	}
}
