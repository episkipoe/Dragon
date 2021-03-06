package com.episkipoe.dragon.guards;

import java.util.Random;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.production.building.LumberTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;

public class GuardRoom extends Room {
	private static final long serialVersionUID = -6574115771401973237L;

	public GuardRoom() { }
	protected GuardRoom(Lair lair) {
		super(lair);
	}
	//TODO Agent can train to add GuardClass here
	@Override
	public String getCommandName() { return "Guard Tower"; }
	
	public Command getBuildCommand(Lair lair) {
		GuardRoom room = new GuardRoom(lair);
		TreasureList tl = new TreasureList();
		tl.add(new IronTreasure(2));
		tl.add(new LumberTreasure());
		Cost cost = new Cost(tl, 4);	
		return new BuildRoomCommand(room, cost);		
	}
	
	@Override
	public void postCreate(int level) {
		Random rnd = new Random();
		int numGuards = rnd.nextInt(level);
		for(int i = 0 ; i < numGuards ; i++) {
			int agentLevel = rnd.nextInt(level);
			GuardClass.create(this, agentLevel);
		}
	}
}
