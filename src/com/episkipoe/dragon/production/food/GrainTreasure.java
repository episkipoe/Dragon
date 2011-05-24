package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.treasure.Treasure;

public class GrainTreasure extends Treasure {
	private static final long serialVersionUID = -7500340135838039706L;
	public GrainTreasure() { this.qty = 1; } 
	public GrainTreasure(int qty) { this.qty = qty; } 

	@Override
	public String getType() { return "Grain"; }

	@Override
	public int getValue(Agent agent) { return (1 * qty); }

}
