package com.episkipoe.dragon.treasure.food;

import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Treasure;

public class GrainTreasure extends Treasure {
	private static final long serialVersionUID = -7500340135838039706L;

	@Override
	public String getType() { return "Grain"; }

	@Override
	public int getValue(Player player) { return (1 * qty); }

}
