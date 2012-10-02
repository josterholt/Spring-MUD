package com.ostwebdev.fantasystrategy.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ostwebdev.fantasystrategy.service.Neo4jDatabasePopulator;

@Controller
public class AdminController {
	/*
	@Autowired
	private Neo4jDatabasePopulator populator;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(@RequestParam(required=false) boolean success, Model model) {
		if(success) {
			model.addAttribute("successMessage", "Record Updated");
		}
		return "/admin/home";
	}
	
	@RequestMapping(value = "/admin/populate-data", method= RequestMethod.GET)
	public String importQuests(Model model) {
		 
		populator.populateDatabase();
		return "redirect:/admin?success=true";
	}
	
	@RequestMapping(value = "/admin/clean-data", method = RequestMethod.GET)
	public ModelAndView clean(Model model) {
		populator.cleanDb();
		return new ModelAndView("redirect:/admin?success=true");
		//return "redirect:/admin";
	}
	*/
}
