package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.treasure.Treasure;

public class MushroomTreasure extends Treasure {
	private static final long serialVersionUID = 1L;

	@Override
	public String getType() { return "Mushroom"; }

	@Override
	public int getValue(Agent agent) { return (1 * qty); }

}
