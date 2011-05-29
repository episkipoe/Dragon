package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.CommerceEvent;
import com.episkipoe.dragon.commerce.Cost;

public class BuildRoomEvent extends CommerceEvent {
	private static final long serialVersionUID = 2361352650528285958L;

	public BuildRoomEvent(Agent agent, Room room, Cost cost, boolean notify) {
		super(agent, room, cost, notify);
	}

	@Override
	public void run() {
		if(!subtractCost()) {
			if(notify) Main.player.popupNotify("Room construction cancelled: you cannot afford it");
			return;
		}
		room.getLair().getRoomSet().add(room);
		if(notify) Main.player.popupNotify("Room construction complete");
		Main.player.getPageManager().refresh();
		postRun();
	}

}
