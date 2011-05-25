package com.episkipoe.dragon.rooms;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commerce.CommerceCommand;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.events.EventScheduler;

public class BuildRoomCommand extends CommerceCommand {
	private static final long serialVersionUID = -2659403363456605251L;
	private boolean scheduled=false;
	public BuildRoomCommand(Room room, Cost cost) {
		super(room, cost);
		scheduled=room.getLair().getRoomSet().buildQueued(room.getClass());
	}

	public void onClick(View v) {
		BuildRoomEvent event = new BuildRoomEvent(room, cost, true); 
		if(v==null) {
			event.run();
		} else {
			EventScheduler.schedule(event, cost.getWaitTime());
		}
		scheduled=true;
		room.getLair().getRoomSet().queueBuild(room.getClass());
		Main.player.popupNotify("Build in progress");
		Main.player.getPageManager().refresh();
	}

	@Override
	public String getCommandName() { return "Build " + room.getCommandName() ; }
	public String getDescription() { 
		if(scheduled) return "In Progress";
		return cost.toString(); 
	}

}
