package com.episkipoe.dragon.treasure.building;

import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Treasure;

public class WoodTreasure extends Treasure {
	private static final long serialVersionUID = -7722486729926976350L;

	@Override
	public String getType() { return "Wood"; }

	@Override
	public int getValue(Player player) { return (2 * qty); }

}
