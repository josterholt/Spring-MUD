package com.ostwebdev.fantasystrategy.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.stereotype.Repository;

import com.ostwebdev.fantasystrategy.domain.Area;

@Repository
public interface AreaRepository extends GraphRepository<Area>,
		RelationshipOperationsRepository<Area> {
	@Query("start area=node({0}) return area")
	Area findById(Long id);
	
	Area findByName(String name);
	/*
	@Query("start area=node({0}) " +
			" where area.type = 'Area' " +
			" return area")
	List<Area> getAllAreas();
	*/
	
	//public Node getOrCreateAreaWithUniqueFactory(String Id, GraphDatabaseService graphDb);
	

}
