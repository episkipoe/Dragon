package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.species.ElfAgent;
import com.episkipoe.dragon.agents.species.HumanAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.ProductionCommand;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.production.building.LumberTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;

public class ForestRoom extends ProductionRoom {
	private static final long serialVersionUID = 9043244252141545347L;

	List<ProductionCommand> products;
	public ForestRoom() { }
	public ForestRoom(Lair lair) { 
		super(lair);
	}

	@Override
	public List<Class<? extends ProductionTreasure>> getProductTypes() {
		List<Class<? extends ProductionTreasure>> productTypes = new ArrayList<Class<? extends ProductionTreasure>>();
		productTypes.add(LumberTreasure.class);
		productTypes.add(MushroomTreasure.class);
		return productTypes;
	}

	public List<Class<? extends Agent>> getSpecies() {
		List<Class<? extends Agent>> species = new ArrayList<Class<? extends Agent>>();
		species.add(ElfAgent.class);
		species.add(HumanAgent.class);
		return species;
	}	
	
	@Override
	public String getCommandName() { return "Forest"; }
	
	@Override
	public Command getBuildCommand(Lair lair) {
		ForestRoom room = new ForestRoom(lair);
		Cost cost = new Cost(6);
		return new BuildRoomCommand(room, cost);
	}

	@Override
	public void postCreate(int level) {
		Random rnd = new Random();
		int numEmployees = rnd.nextInt(level);
		for(int i = 0 ; i < numEmployees ; i++) {
			int agentLevel = rnd.nextInt(level);
			hireAgent(new ElfAgent(agentLevel));
		}	
	}

}
