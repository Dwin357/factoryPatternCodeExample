package com.fdmgroup.cereal;

import java.util.ArrayList;

public class Wizard extends PlayerLegacyWrapper {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Equipable> carrying = new ArrayList<Equipable>();
	private Powers magicPowers = new Powers();
	
	public Wizard() {
		super();
	}
	
	public ArrayList<Equipable> getCarrying() {
		return carrying;
	}
	
	public void dropItem(Equipable item) {
		carrying.remove(item);
	}
	
	public Equipable pickUp(Equipable item) {
		carrying.add(item);
		return item;
	}
	
	public Powers getPowers() {
		return magicPowers;
	}

}
