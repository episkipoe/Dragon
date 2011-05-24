package com.episkipoe.dragon.production.building;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.treasure.Treasure;

public class IronTreasure extends Treasure {
	private static final long serialVersionUID = -7254920043982097635L;

	public IronTreasure() { qty= 1; }
	public IronTreasure(int qty) { this.qty= qty; }

	@Override
	public String getType() { return "Iron" ; }

	@Override
	public int getValue(Agent agent) { return (3 * qty); }

}
