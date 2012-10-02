package com.ostwebdev.fantasystrategy.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
@TypeAlias("Area")
public class Area {
	@GraphId Long nodeId;
	
	@Indexed(unique=true)
	String id;

	private String name;

	public Area() {

	}
	
	public Area(String id, String string) {
		this.id = id;
		this.name = string;
	}

	/*
	@RelatedTo(elementClass = Quest.class, type = "CONTAINS")
	private ArrayList<Quest> quests;
	*/
	public String getId() { return id; }
	public String getName() { return name; }	

}
