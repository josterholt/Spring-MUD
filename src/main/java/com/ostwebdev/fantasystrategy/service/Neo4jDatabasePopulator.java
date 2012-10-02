package com.ostwebdev.fantasystrategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ostwebdev.fantasystrategy.domain.Area;
import com.ostwebdev.fantasystrategy.domain.Quest;
import com.ostwebdev.fantasystrategy.repository.AreaRepository;
import com.ostwebdev.fantasystrategy.repository.QuestRepository;

@Service
public class Neo4jDatabasePopulator {
	@Autowired AreaRepository areaRepository;
	@Autowired QuestRepository questRepository;
	@Autowired Neo4jOperations template;
	
	
	public void populateDatabase() {
		Area area1 = new Area("test", "Test Area");
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
