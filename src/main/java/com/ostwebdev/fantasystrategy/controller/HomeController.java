package com.ostwebdev.fantasystrategy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ostwebdev.fantasystrategy.domain.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"user"})
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		User user = new User();
		user.foo = 1;
		System.out.println(user.foo);
		model.addAttribute("user", user);
		return "home";
	}
	
	@RequestMapping(value = "/user-test", method = RequestMethod.GET)
	public String userTest(@ModelAttribute User user) {
		user.foo += 1;
		System.out.println(user.foo);

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
}
