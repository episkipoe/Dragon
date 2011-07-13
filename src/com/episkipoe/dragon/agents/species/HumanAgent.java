package com.episkipoe.dragon.agents.species;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.rooms.HireCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.gems.GoldTreasure;

public class HumanAgent extends Agent {
	private static final long serialVersionUID = 8481436738548717616L;
	
	public HumanAgent() { }
	public HumanAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Human"; }

	public Command getHireCommand(Room room, int level) {
		TreasureList tl = new TreasureList();
		tl.add(new GoldTreasure(level));
		HumanAgent agent = new HumanAgent(level); 
		Cost cost = new Cost(tl);
		return new HireCommand(room, agent, cost);
	}
}
