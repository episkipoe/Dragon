package com.episkipoe.dragon.dungeon;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;

public class DungeonRoom extends Room {

	public DungeonRoom(Player player, Lair lair) {
		super(player, lair);
		prisoners = new ArrayList<Prisoner>();
	}

	List<Prisoner> prisoners;
	public void add(Prisoner p) { prisoners.add(p); }
	
	public String getCommandName() { return "Prison"; }

	public static Command getBuildCommand(Player player, Lair lair) {
		DungeonRoom room = new DungeonRoom(player, lair);
		TreasureList tl = new TreasureList(player);
		tl.add(new IronTreasure());
		Cost cost = new Cost(tl, 4);
		return new BuildRoomCommand(player, room, cost);	
	}
}
