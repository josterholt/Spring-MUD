package com.ostwebdev.fantasystrategy.domain;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import java.awt.Point;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

import scala.collection.generic.BitOperations.Int;

@NodeEntity
@TypeAlias("Area")
public class Area {
	@GraphId private Long id;
	
	@Indexed(indexType=IndexType.SIMPLE, indexName = "area")	
	String x;
	@Indexed(indexType=IndexType.SIMPLE, indexName = "area")	
	String y;

	//@Indexed(indexType = IndexType.FULLTEXT, indexName = "searchByName")
	String name;

	public Area() {

	}
	
	public Area(Long id, String string) {
		this.id = id;
		this.name = string;
	}

	/*
	@RelatedTo(elementClass = Quest.class, type = "CONTAINS")
	private ArrayList<Quest> quests;
	*/
	public Long getId() { return id; }
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	public String getX() { return this.x; }
	public String getY() { return this.y; }
	public void setX(String x) {this.x = x; }
	public void setY(String y) { this.y = y; }
	
	/*
	public String getCoords() { return this.coords; }
	public void setCoords(String x, String y) { this.coords = x; }
	public void setCoords(S p) { this.coords = p; }
	*/
}
