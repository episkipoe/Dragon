package com.episkipoe.dragon.treasure;

import java.io.Serializable;

import com.episkipoe.dragon.agents.Agent;

public abstract class Treasure implements Serializable {
	private static final long serialVersionUID = 5612971362695594807L;

	public Treasure() { this.qty = 1; }
	public Treasure(int qty) { this.qty = qty; }
	
	public Treasure clone () {
		try {
			Treasure newTreasure = this.getClass().newInstance();
			newTreasure.qty = qty;
			return newTreasure;
		} catch(Exception e) {
			System.out.println("could not add treasure:" + e.getMessage());
		}		
		return null;
	}
	
	public int qty;
	abstract public String getType(); 
	abstract public int getValue(Agent agent);
	
	public String toString() {
		return qty + " " + getType();
	}
	
}

