package com.episkipoe.dragon.dungeon;

import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;

public class DungeonRoom extends Room {
	private static final long serialVersionUID = -3516388211973601575L;
	
	public DungeonRoom() { }
	public DungeonRoom(Lair lair) {
		super(lair);
	}

	AgentList prisoners=null;
	public AgentList getPrisoners() {
		if(prisoners==null) prisoners=new AgentList();
		return prisoners;
	}
	
	public String getCommandName() { return "Prison"; }

	public Command getBuildCommand(Lair lair) {
		DungeonRoom room = new DungeonRoom(lair);
		TreasureList tl = new TreasureList();
		tl.add(new IronTreasure());
		Cost cost = new Cost(tl, 4);
		return new BuildRoomCommand(room, cost);	
	}
	
	public void postCreate(int level) {
	}
}
