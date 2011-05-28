package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commerce.CommerceEvent;
import com.episkipoe.dragon.commerce.Cost;

public class BuildRoomEvent extends CommerceEvent {
	public BuildRoomEvent(Room room, Cost cost, boolean notify) {
		super(room, cost, notify);
	}

	@Override
	public void run() {
		if(!subtractCost()) return;
		room.getLair().getRoomSet().add(room);
		if(notify) Main.player.popupNotify("Room construction complete");
		Main.player.getPageManager().refresh();
	}

}
