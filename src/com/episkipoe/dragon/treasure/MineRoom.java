package com.episkipoe.dragon.treasure;

import java.util.ArrayList;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.agents.species.DwarfAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.food.AleTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.HireCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.gems.MineCommand;


public class MineRoom extends Room {
	private static final long serialVersionUID = -8155843361549611478L;
	
	public MineRoom() { }
	public MineRoom(Lair lair) {
		super(lair);
	}

	@Override
	public String getCommandName() { return "Mine"; }

	AgentList miners=null;
	public AgentList getMiners() {
		if(miners==null) miners = new AgentList();
		return miners;
	}
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		if(lair.getOwner().getRelationship() == Relationship.PLAYER) {
			commandList.add(new MineCommand(lair));
			{
				TreasureList tl = new TreasureList();
				tl.add(new AleTreasure());
				DwarfAgent agent = new DwarfAgent(level); 
				Cost cost = new Cost(tl);
				commandList.add(new HireCommand(this, agent, cost));
			}
		}
	}
	
	public void hireAgent(Agent agent) { 
		getMiners().add(agent);
	}

	public Command getBuildCommand(Lair lair) {
		MineRoom room = new MineRoom(lair);
		Cost cost = new Cost(10);
		return new BuildRoomCommand(room, cost);
	}
}
