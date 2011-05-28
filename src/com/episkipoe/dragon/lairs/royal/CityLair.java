package com.episkipoe.dragon.lairs.royal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.species.HumanAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.BuildLairCommand;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.VillageLair;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class CityLair extends Lair {
	private static final long serialVersionUID = 4348631004707404968L;
	
	public CityLair() {}
	public CityLair(Agent owner) {
		super(owner);
	}

	@Override
	public String getCommandName() { return "City"; }

	public List<Class<? extends Room>> getAllowedRooms() { 
		List<Class<? extends Room>> rooms = new ArrayList<Class<? extends Room>>(); 
		rooms.add(BreweryRoom.class);
		rooms.addAll(getCommonRooms());
		return rooms; 
	}
	
	public boolean createOwner() {
		Random rnd = new Random();
		int level = 2+rnd.nextInt(10);
		HumanAgent ruler = new HumanAgent(level);
		setOwner(ruler);
		return true;
	}
	
	public void postCreate() {
		TreasureRoom treasure = new TreasureRoom(this);
		getRoomSet().add(treasure);	
	}
	
	public List<Class<? extends Lair>> getSubLairs() {
		List<Class<? extends Lair>> subLairs = new ArrayList<Class<? extends Lair>> ();
		subLairs.add(VillageLair.class);
		return subLairs;
	}	
	@Override
	public Command getBuildCommand(LairList kingdom) {
		CityLair lair = new CityLair(Main.player.getPlayerAgent());
		Cost cost = new Cost(1);
		return new BuildLairCommand(kingdom, lair, cost); 
	}	
}
