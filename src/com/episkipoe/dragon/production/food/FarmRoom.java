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

public class FarmRoom extends ProductionRoom {
	private static final long serialVersionUID = -2818358797223917564L;
	
	public FarmRoom() { }
	public FarmRoom(Lair lair) {
		super(lair);
	}
	
	@Override
	public String getCommandName() { return "Farm"; }
	
	@Override
	public List<Class<? extends ProductionTreasure>> getProductTypes() {
		List<Class<? extends ProductionTreasure>> productTypes = new ArrayList<Class<? extends ProductionTreasure>>();
		productTypes.add(CowTreasure.class);
		productTypes.add(GrainTreasure.class);
		return productTypes;
	}

	public List<Class<? extends Agent>> getSpecies() {
		List<Class<? extends Agent>> species = new ArrayList<Class<? extends Agent>>();
		species.add(ElfAgent.class);
		species.add(HumanAgent.class);
		return species;
	}
	
	public Command getBuildCommand(Lair lair) {
		FarmRoom room = new FarmRoom(lair);
		Cost cost = new Cost(6);
		return new BuildRoomCommand(room, cost);		
	}
}
