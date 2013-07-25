package com.ostwebdev.fantasystrategy.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.stereotype.Repository;

import com.ostwebdev.fantasystrategy.domain.Square;

@Repository
public interface SquareRepository extends GraphRepository<Square>,
		RelationshipOperationsRepository<Square> {
	@Query("start area=node({0}) return area")
	Square findById(Long id);
	
	Square findByName(String name);
	/*
	@Query("start area=node({0}) " +
			" where area.type = 'Area' " +
			" return area")
	List<Area> getAllAreas();
	*/
	
	//public Node getOrCreateAreaWithUniqueFactory(String Id, GraphDatabaseService graphDb);
	
	@Query("start n=node:__types__(className = 'Area') WHERE n.x = {0} AND n.y = {1} return n")
	Square findByCoords(int x, int y);
	

}
