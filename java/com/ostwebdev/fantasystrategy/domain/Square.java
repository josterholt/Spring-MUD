package com.ostwebdev.fantasystrategy.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.awt.Point;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
@TypeAlias("Area")
public class Square {
	@GraphId private Long id;

	@Indexed(indexType=IndexType.SIMPLE, indexName = "searchByRegion")	
	private int region;
	
	@Indexed(indexType=IndexType.SIMPLE, indexName = "searchBySquare")	
	private int position;
	
	private int x;
	
	private int y;
	
	@Indexed(indexType = IndexType.FULLTEXT, indexName = "searchByName")
	private String name;
	
	private String description;
	
	/*
	@RelatedTo(type = "LOCATED_IN", direction = Direction.INCOMING)
	private List<Character> characters;
	
	@RelatedTo(type = "CONTAINS", direction = Direction.OUTGOING)
	protected ArrayList<Item> items = new ArrayList<Item>();
	*/
	
	@Fetch @RelatedTo(type="PATH_TO", elementClass = Square.class, direction = Direction.BOTH)
	Set<Square> adjacentSquares = new HashSet<Square>();
	
	
	public Long getId() { 
		return id; 
	}
	
	public Square() {
		
	}
	
	public Square(Long id, String string) {
		this.id = id;
		this.name = string;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public int getPosition() {
		return this.position;
	}
	
	public void setPosition(int position) {
		this.position = position;
		this.y = (int) Math.floor(this.position / Region.num_cols_per_row);
		this.x = this.position - (y * Region.num_cols_per_row);
		
	}
	
	public void setByCoords(int x, int y) {
		this.x = x;
		this.y = y;
		this.position = (y * Region.num_cols_per_row) + x;
	}
	
	public Point getByCoords() {
		
		int y = (int) Math.floor(this.position / Region.num_cols_per_row);
		int x = this.position - (y * Region.num_cols_per_row);
		
		return new Point(x, y);
	}
	
	public int getRegion() {
		return this.region;
	}
	
	public void setRegion(int region) {
		this.region = region;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	@RelatedTo(elementClass = Quest.class, type = "CONTAINS")
	private ArrayList<Quest> quests;
	*/
	/*
	public List<Character> getCharacters() {
		return this.characters;
	}
	*/
	
	public Iterable<Square> getAdjacentSquares() {
		return this.adjacentSquares;
	}
	
	public void addAdjacentSquare(Square square) throws Exception {
		if(square == null){
			throw new Exception("Null square given");
		}
		this.adjacentSquares.add(square);
	}

	/*
	public boolean removeAdjacentSquare(Square square) {
		return this.adjacentSquares.remove(square);
	}
	*/
}
