package com.ostwebdev.fantasystrategy.game.mud;

import java.util.HashMap;

public class ActionResponse {
	protected String callback;
	protected HashMap<String, String> parameters = new HashMap<String, String>();
	
	public String getCallback() {
		return this.callback;
	}
	
	public void setCallback(String value) {
		this.callback = value;
	}
	
	public String getParameter(String key) {
		return this.parameters.get(key);
	}

	public void setParameter(String key, String value) {
		this.parameters.put(key,  value);
	}
}
