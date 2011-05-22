package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Cost;

public class BuildRoomEvent extends Event {
	Room room;
	Cost cost;
	boolean notify;
	public BuildRoomEvent(Player player, Room room, Cost cost, boolean notify) {
		super(player);
		this.room = room;
		this.cost = cost;	
		this.notify = notify;
	}

	@Override
	public void run() {
		if(!room.getLair().subtractCost(cost, notify)) {
			return;
		}
		room.getLair().getRoomSet().add(room);
	}

}
