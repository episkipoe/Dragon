package com.episkipoe.dragon.production.building;

import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Treasure;

public class WoodTreasure extends Treasure {
	private static final long serialVersionUID = -7722486729926976350L;

	public WoodTreasure() { this.qty = 1; }
	public WoodTreasure(int qty) { this.qty = qty; }

	@Override
	public String getType() { return "Wood"; }

	@Override
	public int getValue(Player player) { return (2 * qty); }

}
