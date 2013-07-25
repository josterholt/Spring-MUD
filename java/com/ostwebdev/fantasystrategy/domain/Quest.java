package com.ostwebdev.fantasystrategy.domain;

import java.util.ArrayList;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
@TypeAlias("Quest")
public class Quest {
	@GraphId Long id;	
	private String name;
	private String content;
	
	public Quest(String string) {
		this.name = string;
	}
	
	@RelatedTo(elementClass = Square.class, type = "CONTAINED_BY", direction = Direction.INCOMING)
	Square area;
	
	public String getName() { return name; }
	public String getContent() { return content; }
}
