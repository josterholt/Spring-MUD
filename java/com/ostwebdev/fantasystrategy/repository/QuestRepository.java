package com.ostwebdev.fantasystrategy.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.stereotype.Repository;

import com.ostwebdev.fantasystrategy.domain.Quest;

@Repository
public interface QuestRepository extends GraphRepository<Quest>,
		RelationshipOperationsRepository<Quest> {

}