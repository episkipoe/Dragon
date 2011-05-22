package com.episkipoe.dragon.treasure;

import java.util.ArrayList;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.agents.minions.DwarfAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.food.AleTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.HireCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.gems.MineCommand;


public class MineRoom extends Room {
	public MineRoom(Player player, Lair lair) {
		super(player, lair);
	}

	@Override
	public String getCommandName() { return "Mine"; }

	AgentList miners=null;
	public AgentList getMiners() {
		if(miners==null) miners = new AgentList(player);
		return miners;
	}
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		if(lair.getOwner().getRelationship() == Relationship.PLAYER) {
			commandList.add(new MineCommand(player, lair));
			{
				TreasureList tl = new TreasureList(player);
				tl.add(new AleTreasure());
				DwarfAgent agent = new DwarfAgent(); 
				Cost cost = new Cost(tl);
				commandList.add(new HireCommand(player, this, agent, cost));
			}
		}
	}
	
	public void hireAgent(Agent agent) { 
		getMiners().add(agent);
	}

	public static Command getBuildCommand(Player player, Lair lair) {
		MineRoom room = new MineRoom(player, lair);
		Cost cost = new Cost(10);
		return new BuildRoomCommand(player, room, cost);
	}
}
