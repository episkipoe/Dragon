package com.episkipoe.dragon.rooms.prison;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;

class PrisonRoom extends Room {

	protected PrisonRoom(Player player, Lair lair) {
		super(player, lair);
		prisoners = new ArrayList<Prisoner>();
	}

	List<Prisoner> prisoners;
	public void add(Prisoner p) { prisoners.add(p); }
	
	public String getCommandName() { return "Prison"; }


}
