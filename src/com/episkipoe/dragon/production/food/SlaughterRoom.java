package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.species.HumanAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;

public class SlaughterRoom extends ProductionRoom {
	private static final long serialVersionUID = -3062473222087452598L;

	public SlaughterRoom() { } 
	public SlaughterRoom(Lair lair) { 
		super(lair);
	} 
	
	@Override
	public String getCommandName() { return "Slaughter House"; }	
	
	@Override
	public List<Class<? extends ProductionTreasure>> getProductTypes() {
		List<Class<? extends ProductionTreasure>> productTypes = new ArrayList<Class<? extends ProductionTreasure>>();
		productTypes.add(BeefTreasure.class);
		return productTypes;	
	}

	@Override
	public List<Class<? extends Agent>> getSpecies() {
		List<Class<? extends Agent>> species = new ArrayList<Class<? extends Agent>>();
		species.add(HumanAgent.class);
		return species;
	}

	@Override
	public Command getBuildCommand(Lair lair) {
		SlaughterRoom room = new SlaughterRoom(lair);
		Cost cost = new Cost(6);
		return new BuildRoomCommand(room, cost);		
	}



}
