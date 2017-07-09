package com.fdmgroup.cereal;

import java.io.Serializable;

public class Shield implements Serializable, Equipable, protective {

	private int defense;
	
	private static final long serialVersionUID = 1L;

	public Shield() {
		super();
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int block) {
		this.defense = block;
	}

	public int block() {
		return getDefense();
	}
}
