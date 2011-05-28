package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class VillageLair extends Lair {
	private static final long serialVersionUID = 6434942538638628956L;

	public VillageLair() { }
	public VillageLair(Agent owner) {
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
	
	public void postCreate(int level) {
		List<Class<? extends Room>> roomsToBuild = new ArrayList<Class<? extends Room>>();
		if(level>20) {
			roomsToBuild.add(GuardRoom.class);
		}		
		if(level>3) {
			roomsToBuild.add(FarmRoom.class);
		}
		roomsToBuild.add(TreasureRoom.class);
		addRoomList(roomsToBuild, level);
	}

	@Override
	public Command getBuildCommand(LairList kingdom) {
		VillageLair lair = new VillageLair(Main.player.getPlayerAgent());
		Cost cost = new Cost(1);
		return new BuildLairCommand(kingdom, lair, cost); 
	}	
}
