package com.episkipoe.dragon.rooms.treasure;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

public class TreasureBuilder extends CommandPage {
	Player player;
	TreasureList treasures;
	public TreasureBuilder (Player player, TreasureList treasures) {
		super(player);
		this.treasures = treasures;
	}
	public String getName() { return "Acquire Treasure"; }

	protected void prepareCommands() {
		treasures.add(new GoldTreasure(10));
	}
}
