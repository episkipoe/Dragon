package com.episkipoe.dragon.treasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.species.DwarfAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.treasure.gems.GoldTreasure;


public class MineRoom extends ProductionRoom {
	private static final long serialVersionUID = -8155843361549611478L;
	
	public MineRoom() { }
	public MineRoom(Lair lair) {
		super(lair);
	}

	@Override
	public String getCommandName() { return "Mine"; }
	
	@Override
	public List<Class<? extends ProductionTreasure>> getProductTypes() {
		List<Class<? extends ProductionTreasure>> productTypes = new ArrayList<Class<? extends ProductionTreasure>>();
		productTypes.add(GoldTreasure.class);
		productTypes.add(IronTreasure.class);
		return productTypes;
	}
		
	public List<Class<? extends Agent>> getSpecies() {
		List<Class<? extends Agent>> species = new ArrayList<Class<? extends Agent>>();
		species.add(DwarfAgent.class);
		return species;
	}	

	public Command getBuildCommand(Lair lair) {
		MineRoom room = new MineRoom(lair);
		Cost cost = new Cost(10);
		return new BuildRoomCommand(room, cost);
	}
	
	@Override
	public void postCreate(int level) {
		Random rnd = new Random();
		int numEmployees = rnd.nextInt(level);
		for(int i = 0 ; i < numEmployees ; i++) {
			int agentLevel = rnd.nextInt(level);
			hireAgent(new DwarfAgent(agentLevel));
		}
	}	
}
