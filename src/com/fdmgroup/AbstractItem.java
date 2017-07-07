package com.fdmgroup;

public abstract class AbstractItem extends GameElement {
	
	private static final long serialVersionUID = 1L;
	
	private int durabilityRemaining;
	private boolean broken;

	public AbstractItem() {
		durabilityRemaining = maxDurability();
		broken = false;
	}
	
	public int durability() {
		return durabilityRemaining;
	}
	
	public boolean broken() {
		return broken;
	}
	
	private boolean nonLethalDamage(int damage) {
		return damage < durability();
	}
	
	public void breakItem() {
		degrade(durability());
		broken = true;
	}
	
	public int damage(int damage) {
		if (nonLethalDamage(damage)) {
			degrade(damage);
		} else {
			breakItem();
		}
		return durability();
	}
	
	abstract int maxDurability();
	
	protected int degrade (int damage) {
		durabilityRemaining = durabilityRemaining - damage;
		return durabilityRemaining;
	}
	
}