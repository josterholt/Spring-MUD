package com.ostwebdev.fantasystrategy.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

import com.ostwebdev.fantasystrategy.domain.Quest;

public interface QuestRepository extends GraphRepository<Quest>,
		RelationshipOperationsRepository<Quest> {

}
