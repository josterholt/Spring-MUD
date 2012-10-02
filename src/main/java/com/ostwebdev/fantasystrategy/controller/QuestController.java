package com.ostwebdev.fantasystrategy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ostwebdev.fantasystrategy.domain.Game;

@Controller
public class QuestController {
	@RequestMapping(value = "/admin/quests", method = RequestMethod.GET)
	public String questAdminListing(Model model) {
		return "/admin/quests/questListing";
	}
	
	@RequestMapping(value = "/admin/quests/*", method = RequestMethod.GET)
	public String questAdminDetail(Model model) {
		return "/admin/quests/questDetail";
	}
	
	@RequestMapping(value = "/admin/quests/*", method = RequestMethod.POST)
	public String questAdminDetailProcess(Model model) {
		return "/admin/quests/questListing";
	}

	@RequestMapping(value = "/quests", method = RequestMethod.GET)
	public String questListing(Model model) {
		try {
			model.addAttribute("quests", Game.getInstance().character.getAvailableQuests());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "questListing";
	}
}
