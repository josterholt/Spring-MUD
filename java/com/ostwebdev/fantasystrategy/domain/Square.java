package com.ostwebdev.fantasystrategy.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
@TypeAlias("Area")
public class Square {
	protected int x;
	protected int y;
	protected ArrayList<Character> characters = new ArrayList<Character>();
	protected ArrayList<Item> items = new ArrayList<Item>();
	
	@GraphId Long nodeId;
	
	@Indexed(unique=true)
	String id;

	private String name;

	public Square(String id, String string) {
		this.id = id;
		this.name = string;
	}

	/*
	@RelatedTo(elementClass = Quest.class, type = "CONTAINS")
	private ArrayList<Quest> quests;
	*/
	public String getId() { return id; }
	public String getName() { return name; }	
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
