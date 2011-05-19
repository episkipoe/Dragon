package com.episkipoe.dragon.rooms.treasure;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

import android.view.View;

public class TreasureBuilder extends CommandPage {
	Player player;
	public TreasureBuilder (Player player) {
		super(player);
	}
	public String getName() { return "Acquire Treasure"; }

	public View getActions() {
		return null;
	}
}
