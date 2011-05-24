package com.episkipoe.dragon.lairs.royal;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.rooms.Room;

public class VillageLair extends Lair {
	protected VillageLair() { }
	protected VillageLair(Agent owner) {
		super(owner);
	}

	@Override
	public String getCommandName() { return "Village"; }
	
	public List<Class<? extends Room>> getAllowedRooms() { 
		List<Class<? extends Room>> rooms = new ArrayList<Class<? extends Room>>(); 
		rooms.add(FarmRoom.class);
		rooms.addAll(getCommonRooms());
		return rooms; 
	}

}
