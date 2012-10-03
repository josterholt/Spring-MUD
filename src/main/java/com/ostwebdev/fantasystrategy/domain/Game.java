package com.ostwebdev.fantasystrategy.domain;

import com.ostwebdev.fantasystrategy.domain.Account;
import com.ostwebdev.fantasystrategy.domain.Character;

public class Game {
	public static Game instance;
	public Account account;
	public Character character;
	
	public Game() {
        account = new Account();
	}
	
	public void init() {
		
	}
	
	public static Game getInstance() throws Exception {
		if (instance == null) {
			throw new Exception("Game not initialized");
		}
		return instance;
	}
}
