package com.ostwebdev.fantasystrategy.controller;

import java.util.Locale;

import java.awt.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.GraphRepositoryFactory;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ostwebdev.fantasystrategy.domain.*;
import com.ostwebdev.fantasystrategy.repository.QuestRepository;
import com.ostwebdev.fantasystrategy.repository.AreaRepository;
//import com.ostwebdev.fantasystrategy.repository.*;

@Controller
@SessionAttributes({"user"})
public class AdminController {
	//@Autowired
	//private Neo4jDatabasePopulator populator;
	@Autowired private AreaRepository areaRepository;
	@Autowired private Neo4jOperations template;
	
	
	@RequestMapping(value = "/user-init", method = RequestMethod.GET)
	public String userInit(ModelMap modelMap) {
		User user = new User();
		user.id = 1234;
		user.foo = 0;
		modelMap.addAttribute(user);
		return "admin/home";
	}

	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(@RequestParam(required=false) boolean success, Model model, @ModelAttribute User user) {
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
		area.setX(x);
		area.setY(y);
		areaRepository.save(area);

		return "admin/area/areaList";
	}
	
	@RequestMapping(value = "/admin/{type}", method = RequestMethod.GET)
	public String area(Model model, @PathVariable String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		template.repositoryFor(Class.forName("com.ostwebdev.fantasystrategy.domain." + StringUtils.capitalize(type)));
		
		//GraphRepository<?> repo = (GraphRepository<?>) grf.getRepository(Class.forName(StringUtils.capitalize(type) + "Repository"));
		
		//GraphRepository<?> repo = GraphRepository.class.cast(testRepo);  
 
		//EndResult<?> areas = repo.findAll();
		//model.addAttribute("areas",areas.iterator());
		return "admin/area/areaList";
	}
}
