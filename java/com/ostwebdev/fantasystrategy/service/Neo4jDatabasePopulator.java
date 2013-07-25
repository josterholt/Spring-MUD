package com.ostwebdev.fantasystrategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ostwebdev.fantasystrategy.domain.Square;
import com.ostwebdev.fantasystrategy.domain.Quest;
import com.ostwebdev.fantasystrategy.repository.SquareRepository;
import com.ostwebdev.fantasystrategy.repository.QuestRepository;

@Service
public class Neo4jDatabasePopulator {
	@Autowired SquareRepository areaRepository;
	@Autowired QuestRepository questRepository;
	@Autowired Neo4jOperations template;
	
	
	public void populateDatabase() {
		Square area1 = new Square((long) 1, "Test Area");
		areaRepository.save(area1);		
		
		/*
		Quest q1 = new Quest("Test Quest");
		questRepository.save(q1);
		*/
	}
	
    public void cleanDb() {
        new Neo4jDatabaseCleaner(template).cleanDb();
    }	
}
