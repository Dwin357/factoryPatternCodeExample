package com.fdmgroup.legacycode;

public class Player {
	private int healthPoints;
	private String name;
	
	public Player() {
		super();
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
