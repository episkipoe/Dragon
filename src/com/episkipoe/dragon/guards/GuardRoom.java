package com.episkipoe.dragon.guards;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.production.building.WoodTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;

public class GuardRoom extends Room {

	protected GuardRoom(Player player, Lair lair) {
		super(player, lair);
	}

	@Override
	public String getCommandName() { return "Guard Tower"; }
	
	public static Command getBuildCommand(Player player, Lair lair) {
		GuardRoom room = new GuardRoom(player, lair);
		TreasureList tl = new TreasureList(player);
		tl.add(new IronTreasure(2));
		tl.add(new WoodTreasure());
		Cost cost = new Cost(tl, 4);	
		return new BuildRoomCommand(player, room, cost);		
	}
}
