package com.ostwebdev.fantasystrategy.domain;

import java.awt.Point;

public class User {
	public Integer id;
	public Integer foo;
	
	public Point coords;
	
	public User()
	{
		this.coords = new Point(0,0);
	}
}
