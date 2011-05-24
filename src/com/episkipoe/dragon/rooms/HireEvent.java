package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.CommerceEvent;
import com.episkipoe.dragon.commerce.Cost;

public class HireEvent extends CommerceEvent {
	Agent agent;
	boolean notify;
	public HireEvent(Room room, Agent agent, Cost cost, boolean notify) {
		super(room, cost, notify);
		this.agent = agent;
		this.notify = notify;
	}

	@Override
	public void run() {
		if(!subtractCost()) {
			return;
		}
		room.hireAgent(agent);
		agent.setLocation(room);
	}

}
