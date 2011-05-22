package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.RoomSet;
import com.episkipoe.dragon.rooms.dungeon.DungeonRoom;
import com.episkipoe.dragon.treasure.Cost;
import com.episkipoe.dragon.treasure.MineRoom;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.TreasureRoom;
import com.episkipoe.dragon.treasure.building.IronTreasure;

public class MountainLair extends Lair {
	public MountainLair(Player player, Agent owner) {
		super(player, owner);
	}

	public String getCommandName() { return "Mountain Lair"; }
	
	public List<Command> getRoomBuildCommands() {
		List<Command> cmds = new ArrayList<Command>();
		RoomSet rooms = getRoomSet();
		if (!rooms.hasRoom(MineRoom.class)) {
			MineRoom room = new MineRoom(player, this);
			Cost cost = new Cost(10);
			cmds.add(new BuildRoomCommand(player, room, cost));
		} 
		if (!rooms.hasRoom(TreasureRoom.class)) {
			TreasureRoom room = new TreasureRoom(player, this);
			TreasureList tl = new TreasureList(player);
			tl.add(new IronTreasure());
			Cost cost = new Cost(tl, 4);
			cmds.add(new BuildRoomCommand(player, room, cost));
		}
		if (!rooms.hasRoom(DungeonRoom.class)) {
			DungeonRoom room = new DungeonRoom(player, this);
			TreasureList tl = new TreasureList(player);
			tl.add(new IronTreasure());
			Cost cost = new Cost(tl, 4);
			cmds.add(new BuildRoomCommand(player, room, cost));		
		}
		return cmds;
	}
}
