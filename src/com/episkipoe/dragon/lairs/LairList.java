package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.forest.ForestLair;
import com.episkipoe.dragon.lairs.mountain.MountainLair;
import com.episkipoe.dragon.lairs.royal.CastleLair;
import com.episkipoe.dragon.lairs.royal.CityLair;
import com.episkipoe.dragon.rooms.Room;

public class LairList extends CommandPage {
	private static final long serialVersionUID = 7999013889938944161L;
	
	Agent owner;
	public LairList(Agent owner) {
		this.owner = owner;
	}
	
	public String getCommandName() { 
		if(Agent.getRelationship(owner)==Relationship.PLAYER) {
			return "Explore your realm"; 
		} else {
			return "Visit " + owner.getName(); 
		}
	}
	public String getDescription() {
		return numLairs() + " states";
	}
	public boolean isMine() { return (Agent.getRelationship(owner) == Relationship.PLAYER); }
	
	List<Lair> lairs = null;
	public void addLair(Lair l) { 
		l.setKingdom(this);
		getLairs().add(l); 
	}
	public List<Lair> getLairs() { 
		if(lairs==null) lairs = new ArrayList<Lair>();
		return lairs; 
	}
	public int numLairs() { return lairs.size(); }

	public List<Room> getAllRoomsOfType(Class<? extends Room> type) {
		List<Room> rooms = new ArrayList<Room>();
		for (Lair l : getLairs()) {
			if(l.getRoomSet().has(type)) {
				rooms.add(l.getRoomSet().get(type));
			}	
		}
		return rooms;
	}

	LairBuilder lairBuilder=null;
	private LairBuilder getLairBuilder() {
		if(lairBuilder==null) lairBuilder = new LairBuilder(this);
		return lairBuilder;
	}

	protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		if(lairs==null) return;
		for(Lair l : lairs) commandList.add(l);
		if(isMine()) commandList.add(getLairBuilder());
	}
	
	public static List<Class<? extends Lair>> availableTypes() {
		List<Class<? extends Lair>> lairs = new ArrayList<Class<? extends Lair>>();
		lairs.add(CastleLair.class);
		lairs.add(CityLair.class);
		lairs.add(ForestLair.class);
		lairs.add(MountainLair.class);
		lairs.add(VillageLair.class);
		return lairs;
	}
	
	public static List<Class<? extends Lair>> seatsOfGovernment() {
		List<Class<? extends Lair>> lairs = new ArrayList<Class<? extends Lair>>();
		for(Class<? extends Lair> type : availableTypes()) {
			try {
				Lair l = type.newInstance();
				if(!l.createOwner()) continue;
			} catch(Exception e) {
				continue;
			}
			lairs.add(type);
		}
		return lairs;
	}


}