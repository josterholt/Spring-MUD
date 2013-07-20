package com.ostwebdev.fantasystrategy.domain;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import com.ostwebdev.fantasystrategy.game.character.Attribute;
import com.ostwebdev.fantasystrategy.repository.AreaRepository;

@NodeEntity
public class Character {
	@GraphId private Long id;
	
	public Item[] items;
	public Area area;
	
	@Autowired AreaRepository areaRepo;
	
	// Vitals/attributes
	protected int health;
	protected int energy;
	protected int exp;
	protected HashMap<String, Attribute> attribs = new HashMap<String, Attribute>(); //str, int, agi, spr, dex	
	
	public Attribute getAttribute(String key) throws Exception {
		if(attribs.containsKey(key)) {
			return attribs.get(key);
		}
		throw new Exception("Invalid attribute");
	}

	public void setArea(Area area)
	{
		this.area = area;
	}
	
	public Object getAvailableQuests() {
		// TODO Auto-generated method stub
		return null;
	}
}
