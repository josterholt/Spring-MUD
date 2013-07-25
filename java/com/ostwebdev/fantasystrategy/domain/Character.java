package com.ostwebdev.fantasystrategy.domain;

import java.util.HashMap;

import org.neo4j.graphdb.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.ostwebdev.fantasystrategy.game.character.Attribute;
import com.ostwebdev.fantasystrategy.repository.SquareRepository;

@NodeEntity
public class Character {
	@GraphId private Long id;
	
	@RelatedTo(type="OWNED_BY", direction = Direction.INCOMING)
	private User user;
	
	private Item[] items;
	
	@RelatedTo(type = "LOCATED_IN", direction = Direction.OUTGOING)
	private int square;
	
	@Autowired SquareRepository areaRepo;
	
	// Vitals/attributes
	private int health;
	private int energy;
	private int experience;
	private HashMap<String, Attribute> attribs = new HashMap<String, Attribute>(); //str, int, agi, spr, dex	
	
	
	public int getHealth() {
		return this.health;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public int getExperience() {
		return this.experience;
	}

	public Attribute getAttribute(String key) throws Exception {
		if(attribs.containsKey(key)) {
			return attribs.get(key);
		}
		throw new Exception("Invalid attribute");
	}

	public void move(int x, int y) {
		// @todo This should be moved up 
		this.square = (y * Region.num_cols_per_row) + x;
	}

	public void move(int square) {
		this.square = square;
	}
	
	public int getSquare() {
		return this.square;
	}
	
	
	public Object getAvailableQuests() {
		// TODO Auto-generated method stub
		return null;
	}
}
