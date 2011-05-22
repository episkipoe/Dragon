package com.episkipoe.dragon.guards;

import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;

public class GuardRoom extends Room {

	protected GuardRoom(Player player, Lair lair) {
		super(player, lair);
	}

	@Override
	public String getCommandName() { return "Guard Tower"; }

}
