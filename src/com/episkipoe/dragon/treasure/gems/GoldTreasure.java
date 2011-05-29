package com.episkipoe.dragon.treasure.gems;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.treasure.Treasure;


public class GoldTreasure extends Treasure {
	private static final long serialVersionUID = 1856974886586511127L;
	
	public GoldTreasure() { super(); }
	public GoldTreasure (int qty) { 
		this.qty = qty;
	}
	
	@Override
	public String getType() { return "Gold"; }

	@Override
	public int getValue(Agent agent) { return qty; }
	
}

