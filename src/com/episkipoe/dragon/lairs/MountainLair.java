package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.dungeon.DungeonRoom;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.MineRoom;

public class MountainLair extends Lair {
	public MountainLair(Player player, Agent owner) {
		super(player, owner);
	}

	public String getCommandName() { return "Mountain Lair"; }

	public List<Class<? extends Room>> getAllowedRooms() { 
		List<Class<? extends Room>> rooms = new ArrayList<Class<? extends Room>>(); 
		rooms.add(MineRoom.class);
		rooms.add(DungeonRoom.class);
		rooms.add(BreweryRoom.class);
		rooms.addAll(getCommonRooms());
		return rooms; 
	}
}
