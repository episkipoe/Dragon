package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.rooms.Room;

public abstract class CommerceEvent extends Event {
	protected Room room;
	protected Cost cost;
	protected boolean notify;
	public CommerceEvent(Room room, Cost cost, boolean notify) {
		this.room = room;
		this.cost = cost;	
		this.notify = notify;
	}

	protected boolean subtractCost() {
		return CommerceUtils.subtractCost(room.getLair(), cost);
	}
}
