package com.ostwebdev.fantasystrategy.controller;

import java.util.Locale;

import java.awt.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ostwebdev.fantasystrategy.domain.Area;
import com.ostwebdev.fantasystrategy.repository.AreaRepository;
import com.ostwebdev.fantasystrategy.service.Neo4jDatabasePopulator;

@Controller
public class AdminController {
	//@Autowired
	//private Neo4jDatabasePopulator populator;
	@Autowired
	private AreaRepository areaRepository;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(@RequestParam(required=false) boolean success, Model model) {
		if(success) {
			model.addAttribute("successMessage", "Record Updated");
		}
		return "admin/home";
	}

	@RequestMapping(value = "/admin/area", method = RequestMethod.GET)
	public String area(Model model) {
		EndResult<Area> areas = areaRepository.findAll();
		model.addAttribute("areas",areas.iterator());
		return "admin/area/areaList";
	}

	@RequestMapping(value = "/admin/area/{id}", method = RequestMethod.GET)
	public String area(@ModelAttribute("area") Area area, @PathVariable Long id, Model model) throws Exception {
		if(id != 0) {
			area = areaRepository.findById(id);
			if(area != null) {
				System.out.println(area.getName());
				model.addAttribute("area", area);
			} else {
				throw new Exception("Area not found");
			}
		} else {
			model.addAttribute("area", new Area());
		}
		return "admin/area/areaDetail";
	}
	
	@RequestMapping(value = "/admin/area/{id}", method = RequestMethod.POST)
	public String area_save(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("x") String x, @RequestParam("y") String y) throws Exception {
		Area area;
		if(id != 0) {
			area = areaRepository.findById(id);
			if(area == null) {
				throw new Exception("Area not found");
			}
		} else {
			area = new Area();
		}		
		
		area.setName(name);
		//area.setCoords(x, y);
		area.setX(x);
		area.setY(y);
		areaRepository.save(area);
		/*
		Area area;
		area = areaRepository.findByCoords(x, y);
		if(area == null) {
			area = new Area();
			area.setName(name);
			area.setY(y);
			area.setX(x);			
		}
		areaRepository.save(area);		
		*/
		return "admin/area/areaList";
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
}
