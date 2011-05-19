package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

public abstract class Room extends CommandPage {

	protected Room(Player player) {
		super(player);
	}

}

