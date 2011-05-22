package com.episkipoe.dragon.treasure;

import java.io.Serializable;

import com.episkipoe.dragon.player.Player;

public abstract class Treasure implements Serializable {
	private static final long serialVersionUID = 5612971362695594807L;
	
	public int qty;
	abstract public String getType(); 
	abstract public int getValue(Player player);
	
	public String toString() {
		return qty + " " + getType();
	}
}

