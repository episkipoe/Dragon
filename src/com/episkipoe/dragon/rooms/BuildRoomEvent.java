package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.commerce.CommerceEvent;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.player.Player;

public class BuildRoomEvent extends CommerceEvent {
	public BuildRoomEvent(Player player, Room room, Cost cost, boolean notify) {
		super(player, room, cost, notify);
	}

	@Override
	public void run() {
		if(!subtractCost()) return;
		room.getLair().getRoomSet().add(room);
		//TODO refresh display 
	}

}
