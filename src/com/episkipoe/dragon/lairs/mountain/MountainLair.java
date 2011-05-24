package com.episkipoe.dragon.lairs.mountain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.DragonAgent;
import com.episkipoe.dragon.dungeon.DungeonRoom;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.MineRoom;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class MountainLair extends Lair {
	public MountainLair() { }
	public MountainLair(Agent owner) {
		super(owner);
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
	

	public boolean createOwner() {
		Random rnd = new Random();
		int level = 2+rnd.nextInt(20);
		setOwner(new DragonAgent(level));
		return true;
	}
	
	public void populate() {
		Room treasure = new TreasureRoom(this);
		getRoomSet().add(treasure);	
	}
	
	public List<Class<? extends Lair>> getSubLairs() {
		List<Class<? extends Lair>> subLairs = new ArrayList<Class<? extends Lair>> ();
		subLairs.add(MountainLair.class);
		return subLairs;
	}
}
