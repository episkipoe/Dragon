package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.treasure.Treasure;

public class AleTreasure extends Treasure {
	private static final long serialVersionUID = 2239854700589973679L;

	public AleTreasure() { this.qty = 1; }
	public AleTreasure(int qty) { this.qty = qty; }
	
	@Override
	public String getType() { return "Ale"; }

	@Override
	public int getValue(Agent agent) { return (10 * qty); }

}
