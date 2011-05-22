package com.episkipoe.dragon.rooms;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Cost;

public class BuildRoomCommand extends Command {
	Room room;
	Cost cost;
	public BuildRoomCommand(Player player, Room room, Cost cost) {
		super(player);
		this.room = room;
		this.cost = cost;
	}

	public void onClick(View v) {
		BuildRoomEvent event = new BuildRoomEvent(player, room, cost, true); 
		event.run();
	}

	@Override
	public String getCommandName() { return "Build " + room.getCommandName() ; }
	public String getDescription() {
		return cost.toString();
	}

}
