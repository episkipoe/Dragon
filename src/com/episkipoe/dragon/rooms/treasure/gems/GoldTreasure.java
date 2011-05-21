package com.episkipoe.dragon.rooms.treasure.gems;

import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.treasure.Treasure;


public class GoldTreasure extends Treasure {
	private static final long serialVersionUID = 1856974886586511127L;

	public GoldTreasure (int qty) { 
		this.qty = qty;
	}
	
	@Override
	public String getType() { return "Gold"; }

	@Override
	public int getValue(Player player) { return qty; }
	
}

