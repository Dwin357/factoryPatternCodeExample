package com.fdmgroup;

public class Shield extends AbstractItem implements HandSlot {

	private static final long serialVersionUID = 1L;
	
	private int defense;
	private int attack;
	
	public Shield() {
		super();
		defense = 5;
		attack = 0;
	}
	
	public int attack() {		
		return attack;
	}
	
	public int defense() {
		return defense;
	}

	@Override
	int maxDurability() {
		return 10;
	}

}
