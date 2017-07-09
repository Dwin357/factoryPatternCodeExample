package com.fdmgroup.legacycode;

public class HealthPack {

	private int HealthPoints;
	
	public HealthPack() {
		super();
	}
	
	public HealthPack(int points){
		super();
		HealthPoints = points;
	}

	public int getHealthPoints() {
		return HealthPoints;
	}

	public void setHealthPoints(int points) {
		this.HealthPoints = points;
	}
	
	
}
