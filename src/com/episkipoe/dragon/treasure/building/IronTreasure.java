package com.episkipoe.dragon.treasure.building;

import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Treasure;

public class IronTreasure extends Treasure {
	private static final long serialVersionUID = -7254920043982097635L;

	public IronTreasure() { }

	@Override
	public String getType() { return "Iron" ; }

	@Override
	public int getValue(Player player) { return (3 * qty); }

}
