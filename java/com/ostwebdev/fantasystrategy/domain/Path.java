package com.ostwebdev.fantasystrategy.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "PATH")
public class Path {
	@StartNode Square square1;
	@EndNode Square square2;
	
	Path(Square square1,  Square square2) {
		this.square1 = square1;
		this.square2 = square2;
	}
}
