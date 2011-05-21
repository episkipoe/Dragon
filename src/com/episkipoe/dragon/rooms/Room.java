package com.episkipoe.dragon.rooms;

import java.util.Collection;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;

public abstract class Room extends CommandPage {
	protected Lair lair;
	protected Room(Player player, Lair lair) {
		super(player);
		this.lair = lair;
	}
	
	public Collection<Command> acquireWealth() { return null; }

}

