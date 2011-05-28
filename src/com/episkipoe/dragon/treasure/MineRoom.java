package com.episkipoe.dragon.treasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.species.DwarfAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.gems.GoldTreasure;
import com.episkipoe.dragon.treasure.gems.MineCommand;


public class MineRoom extends Room {
	private static final long serialVersionUID = -8155843361549611478L;
	
	public MineRoom() { }
	public MineRoom(Lair lair) {
		super(lair);
	}

	@Override
	public String getCommandName() { return "Mine"; }

	public List<Command> getHireCommands() { 
		List<Command> cmds = new ArrayList<Command>();
		cmds.add(DwarfAgent.hireCommand(this, level));
		return cmds;
	}
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		if(lair.isMine()) {
			commandList.add(new MineCommand(lair, new GoldTreasure(10)));
			commandList.add(new MineCommand(lair, new IronTreasure(1)));
			addCommonRoomCommands();
		}
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
