package com.episkipoe.dragon.treasure.gems;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.treasure.Treasure;

public class DiamondTreasure extends Treasure {

	private static final long serialVersionUID = 1026116556376286904L;
	
	public DiamondTreasure() { qty = 1; }
	public DiamondTreasure(int qty) { this.qty = qty; }

	@Override
	public String getType() { return "Diamond"; }

	@Override
	public int getValue(Agent agent) { return (100 * qty); }

}
