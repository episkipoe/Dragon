package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.species.DwarfAgent;
import com.episkipoe.dragon.agents.species.HumanAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;

public class BreweryRoom extends ProductionRoom {
	private static final long serialVersionUID = 8794169756942869835L;
	
	public BreweryRoom() { }
	public BreweryRoom(Lair lair) {
		super(lair);
	}
	
	@Override
	public String getCommandName() { return "Brewery"; }
	
	@Override
	public List<Class<? extends ProductionTreasure>> getProductTypes() {
		List<Class<? extends ProductionTreasure>> productTypes = new ArrayList<Class<? extends ProductionTreasure>>();
		productTypes.add(AleTreasure.class);
		return productTypes;
	}
		
	public List<Class<? extends Agent>> getSpecies() {
		List<Class<? extends Agent>> species = new ArrayList<Class<? extends Agent>>();
		species.add(DwarfAgent.class);
		species.add(HumanAgent.class);
		return species;
	}
	
	public Command getBuildCommand(Lair lair) {
		BreweryRoom room = new BreweryRoom(lair);
		Cost cost = new Cost(3);
		return new BuildRoomCommand(room, cost);
	}
	

}
