package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.rooms.Room;

public abstract class CommerceEvent extends Event {
	private static final long serialVersionUID = -5499278697213147841L;
	protected Room room;
	protected Cost cost;
	protected boolean notify;
	public CommerceEvent(Agent agent, Room room, Cost cost, boolean notify) {
		super(agent, cost.getWaitTime());
		this.room = room;
		this.cost = cost;	
		this.notify = notify;
	}

	protected boolean subtractCost() {
		return CommerceUtils.subtractCost(room.getLair(), cost);
	}
}
