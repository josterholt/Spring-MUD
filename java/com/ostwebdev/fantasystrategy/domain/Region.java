package com.ostwebdev.fantasystrategy.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
@TypeAlias("Region")
public class Region {
	public static int num_cols_per_row = 4;
}
