package com.ostwebdev.fantasystrategy.controller;

import java.util.Locale;

import java.awt.List;
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
import com.ostwebdev.fantasystrategy.repository.SquareRepository;
//import com.ostwebdev.fantasystrategy.repository.*;

@Controller
@SessionAttributes({"user"})
public class AdminController {
	//@Autowired
	//private Neo4jDatabasePopulator populator;
	@Autowired private SquareRepository squareRepository;
	@Autowired private Neo4jOperations template;
	
	
	@RequestMapping(value = "/user-init", method = RequestMethod.GET)
	public String userInit(ModelMap modelMap) {
		User user = new User();
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
		EndResult<Square> areas = squareRepository.findAll();
		model.addAttribute("areas",areas.iterator());
		return "admin/area/areaList";
	}
	
	@RequestMapping(value = "/admin/area/{id}", method = RequestMethod.GET)
	public String area(@ModelAttribute("area") Square area, @PathVariable Long id, Model model) throws Exception {
		if(id != 0) {
			area = squareRepository.findById(id);
			if(area != null) {
				System.out.println(area.getName());
				model.addAttribute("area", area);
			} else {
				throw new Exception("Area not found");
			}
		} else {
			model.addAttribute("area", new Square());
		}
		return "admin/area/areaDetail";
	}
	
	@RequestMapping(value = "/admin/area/{id}", method = RequestMethod.POST)
	public String area_save(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("x") String x, @RequestParam("y") String y) throws Exception {
		Square area;
		if(id != 0) {
			area = squareRepository.findById(id);
			if(area == null) {
				throw new Exception("Area not found");
			}
		} else {
			area = new Square();
		}		
		
		area.setName(name);
		area.setByCoords(Integer.valueOf(x), Integer.valueOf(y));
		//area.setX(x);
		//area.setY(y);
		squareRepository.save(area);

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
	
	@RequestMapping(value = "/admin/populateAreas", method = RequestMethod.GET)
	public String populateAreas(Model model) throws Exception {
		Square area1 = new Square();
		area1.setName("Area 1");
		area1.setRegion(0);
		area1.setByCoords(0,  0);
		squareRepository.save(area1);
		
		Square area2 = new Square();
		area2.setName("Area 2");
		area2.setRegion(0);
		area2.setByCoords(0,  1);
		area2.addAdjacentSquare(area1);
		squareRepository.save(area2);
		
		Square area3 = new Square();
		area3.setName("Area 3");
		area3.setRegion(0);
		area3.setByCoords(0, 2);
		area3.addAdjacentSquare(area2);		
		squareRepository.save(area3);

		return "admin/home";
	}
	
	@RequestMapping(value = "/admin/listsquares", method = RequestMethod.GET)
	public String listSquares(Model model) throws Exception {
		Square square = squareRepository.findByCoords(0, 0);
		System.out.println(square.getX() + ", " + square.getY());
		System.out.println("Related Items:");
		for(Square s : square.getAdjacentSquares()) {
			System.out.println(s.getX() + ", " + s.getY());
		}
		return "admin/home";
		
	}
}
