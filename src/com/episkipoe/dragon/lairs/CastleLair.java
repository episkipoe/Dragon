package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.dungeon.DungeonRoom;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.rooms.Room;

public class CastleLair extends Lair {
	public CastleLair(Player player, Agent owner) {
		super(player, owner);
	}

	@Override
	public String getCommandName() { return "Castle"; }
	
	public List<Class<? extends Room>> getAllowedRooms() { 
		List<Class<? extends Room>> rooms = new ArrayList<Class<? extends Room>>(); 
		rooms.add(DungeonRoom.class);
		rooms.add(BreweryRoom.class);
		rooms.add(FarmRoom.class);
		rooms.addAll(getCommonRooms());
		return rooms; 
	}
}
