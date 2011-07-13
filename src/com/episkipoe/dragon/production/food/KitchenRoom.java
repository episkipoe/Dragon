package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.species.ElfAgent;
import com.episkipoe.dragon.agents.species.HumanAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;

public class KitchenRoom extends ProductionRoom {
	private static final long serialVersionUID = -3674482984714378812L;

	public KitchenRoom() {} 
	public KitchenRoom(Lair lair) {
		super(lair);
	} 
	
	@Override public String getCommandName() { return "Kitchen"; }
	
	@Override
	public List<Class<? extends ProductionTreasure>> getProductTypes() {
		//TODO kitchen products
		return null;
	}

	@Override
	public List<Class<? extends Agent>> getSpecies() {
		List<Class<? extends Agent>> species = new ArrayList<Class<? extends Agent>>();
		species.add(HumanAgent.class);
		species.add(ElfAgent.class);
		return species;
	}

	@Override
	public Command getBuildCommand(Lair lair) {
		KitchenRoom room = new KitchenRoom (lair);
		Cost cost = new Cost(6);
		return new BuildRoomCommand(room, cost);		
	}


}
