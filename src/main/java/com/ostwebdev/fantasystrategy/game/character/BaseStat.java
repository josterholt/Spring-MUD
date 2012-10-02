package com.ostwebdev.fantasystrategy.game.character;

public class BaseStat {
	private int _baseValue;
	private int _buffValue;
	private int _expToLevel;
	private float _levelModifier;
	
	public BaseStat() {
		_baseValue = 0;
		_buffValue = 0;
		_levelModifier = 1.1f;
		_expToLevel = 100;
	}
	
	public int getBaseValue() {
		return _baseValue;
	}
	
	public void setBaseValue(int value) {
		_baseValue = value;
	}
	
	public int getBuffValue() {
		return this._buffValue;
	}
	
	public void setBuffValue(int value) {
		_buffValue = value;
	}
	
	public int getExpToLevel() {
		return this._expToLevel;
	}
	
	public void setExpToLevel(int value) {
		_expToLevel = value;
	}
	
	private int CalculateExpToLevel() {
		return (int) (this._expToLevel * this._levelModifier);
	}
	
	public void LevelUp() {
		_expToLevel = (int) CalculateExpToLevel();
		_baseValue++;
	}
	
	public float AdjustedValue() {
		return _baseValue + _buffValue;
	}
	
	
}
