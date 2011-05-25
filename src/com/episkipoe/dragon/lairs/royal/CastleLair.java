package com.episkipoe.dragon.lairs.royal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.classes.royalty.KingClass;
import com.episkipoe.dragon.dungeon.DungeonRoom;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class CastleLair extends Lair {
	private static final long serialVersionUID = 8633086528040582046L;

	public CastleLair() { }
	public CastleLair(Agent owner) {
		super(owner);
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
	

	public boolean createOwner() {
		Random rnd = new Random();
		int level = 2+rnd.nextInt(20);
		setOwner(new KingClass(level));
		return true;
	}
	
	public void populate() {
		setOwner(owner);
		TreasureRoom treasure = new TreasureRoom(this);
		getRoomSet().add(treasure);	
	}
	
	public List<Class<? extends Lair>> getSubLairs() {
		List<Class<? extends Lair>> subLairs = new ArrayList<Class<? extends Lair>> ();
		subLairs.add(CastleLair.class);
		return subLairs;
	}
}
