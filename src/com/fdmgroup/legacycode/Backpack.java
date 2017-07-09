package com.fdmgroup.legacycode;

import java.util.ArrayList;

public class Backpack {
	ArrayList<HealthPack> healPacks = new ArrayList<HealthPack>();
	
	public Backpack() {
		super();
	}

	public void addHealthPack(HealthPack heal) {
		this.healPacks.add(heal);
	}
	
	public HealthPack useHealthPack() {
		return this.healPacks.remove(0);
	}
	
	public int getNumPacks() {
		return this.healPacks.size();
	}

}
