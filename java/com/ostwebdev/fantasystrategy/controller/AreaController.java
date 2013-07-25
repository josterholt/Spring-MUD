package com.ostwebdev.fantasystrategy.controller;

import java.util.List;

import org.neo4j.helpers.collection.ClosableIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ostwebdev.fantasystrategy.domain.Square;
import com.ostwebdev.fantasystrategy.domain.Game;
import com.ostwebdev.fantasystrategy.repository.SquareRepository;

@Controller
public class AreaController {
	@Autowired
	SquareRepository areaRepository;
	
	
	@RequestMapping(value = "/areas", method = RequestMethod.GET)
	public String areas(Model model) {
		EndResult<Square> areas = areaRepository.findAll();		
		model.addAttribute("areas", areas.iterator());
		return "areas/areaList";
	}
	
	@RequestMapping(value = "/areas/{id}", method = RequestMethod.GET)
	public String areas(Model model, @PathVariable Long id) {
		Square area = areaRepository.findById(id);
		
		model.addAttribute("area", area);
		return "areas/areaDetail";
	}	
}
