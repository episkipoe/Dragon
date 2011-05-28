package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.events.Event;

public abstract class RoomEvent extends Event {
	private static final long serialVersionUID = 6232326306216672202L;
	protected Room room;
	public RoomEvent(Room room, int delay) {
		super(room.getEvents(), delay);
	}
}
