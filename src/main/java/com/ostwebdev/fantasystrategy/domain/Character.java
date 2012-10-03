package com.ostwebdev.fantasystrategy.domain;

import java.util.HashMap;

import com.ostwebdev.fantasystrategy.game.character.Attribute;

public class Character {
	// Vitals/attributes
	protected int health;
	protected int energy;
	protected int exp;
	protected HashMap<String, Attribute> attribs = new HashMap<String, Attribute>(); //str, int, agi, spr, dex

	// Spacial
	protected Square square;
	
	
	public Attribute getAttribute(String key) throws Exception {
		if(attribs.containsKey(key)) {
			return attribs.get(key);
		}
		throw new Exception("Invalid attribute");
	}


	public Object getAvailableQuests() {
		// TODO Auto-generated method stub
		return null;
	}
}
