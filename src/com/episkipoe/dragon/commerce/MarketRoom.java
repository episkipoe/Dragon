package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.production.building.LumberTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;

public class MarketRoom extends Room {
	private static final long serialVersionUID = 2857299147844140667L;

	public MarketRoom() { }
	protected MarketRoom(Lair lair) {
		super(lair);
	}
	
	@Override public String getCommandName() { return "Market" ; }
	
	@Override
	public Command getBuildCommand(Lair lair) {
		MarketRoom room = new MarketRoom(lair);
		TreasureList tl = new TreasureList();
		tl.add(new IronTreasure(2));
		tl.add(new LumberTreasure(4));
		Cost cost = new Cost(tl, 4);	
		return new BuildRoomCommand(room, cost);		
	}

	@Override public void postCreate(int level) { }


}
