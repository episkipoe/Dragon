package com.episkipoe.dragon.dungeon;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;

public class DungeonRoom extends Room {

	public DungeonRoom() { }
	public DungeonRoom(Lair lair) {
		super(lair);
		prisoners = new ArrayList<Prisoner>();
	}

	List<Prisoner> prisoners;
	public void add(Prisoner p) { prisoners.add(p); }
	
	public String getCommandName() { return "Prison"; }

	public Command getBuildCommand(Lair lair) {
		DungeonRoom room = new DungeonRoom(lair);
		TreasureList tl = new TreasureList();
		tl.add(new IronTreasure());
		Cost cost = new Cost(tl, 4);
		return new BuildRoomCommand(room, cost);	
	}
}
