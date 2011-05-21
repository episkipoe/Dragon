package com.episkipoe.dragon.rooms.treasure;

import com.episkipoe.dragon.player.Player;


public class GoldTreasure extends Treasure {
	private static final long serialVersionUID = 1856974886586511127L;

	GoldTreasure () { }
	GoldTreasure (int qty) { 
		this.qty = qty;
	}
	
	@Override
	public String getType() { return "Gold"; }

	@Override
	public int getValue(Player player) { return qty; }
	
}

