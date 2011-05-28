package com.episkipoe.dragon.agents.species;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.production.food.MushroomTreasure;
import com.episkipoe.dragon.rooms.HireCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.gems.GoldTreasure;

public class ElfAgent extends Agent {
	private static final long serialVersionUID = -1746273078372318869L;
	
	public ElfAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Elf"; }

	static public Command hireCommand(Room room, int level) {
		TreasureList tl = new TreasureList();
		tl.add(new MushroomTreasure());
		tl.add(new GoldTreasure(level));
		DwarfAgent agent = new DwarfAgent(level); 
		Cost cost = new Cost(tl);
		return new HireCommand(room, agent, cost);
	}
}
