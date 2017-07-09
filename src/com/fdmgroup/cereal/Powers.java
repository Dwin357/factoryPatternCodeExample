package com.fdmgroup.cereal;

import java.io.Serializable;

public class Powers implements Serializable {

	private static final long serialVersionUID = 1L;
	private int level;
	
	public Powers() {
		super();
		level = 1;
	}
	
	public Powers(int lvl) {
		super();
		level = lvl;
	}
	
	public void levelUp() {
		level = level + 1;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int fireBall() {
		return getLevel() * -5;
	}
	
	public int cureWounds() {
		return getLevel() * 3;
	}

}
