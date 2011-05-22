package com.episkipoe.dragon.rooms;

import android.view.View;

import com.episkipoe.dragon.commerce.CommerceCommand;
import com.episkipoe.dragon.events.EventScheduler;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Cost;

public class BuildRoomCommand extends CommerceCommand {
	public BuildRoomCommand(Player player, Room room, Cost cost) {
		super(player, room, cost);
	}

	boolean scheduled=false;
	public void onClick(View v) {
		BuildRoomEvent event = new BuildRoomEvent(player, room, cost, true); 
		EventScheduler.schedule(event, cost.getWaitTime());
		scheduled=true;
		enabled=false;
	}

	@Override
	public String getCommandName() { return "Build " + room.getCommandName() ; }
	public String getDescription() { 
		if(scheduled) return "In Progress";
		return cost.toString(); 
	}

}
