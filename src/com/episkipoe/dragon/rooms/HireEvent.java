package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.CommerceEvent;
import com.episkipoe.dragon.commerce.Cost;

public class HireEvent extends CommerceEvent {
	private static final long serialVersionUID = 2589104364553998816L;
	Agent employee;
	boolean notify;
	public HireEvent(Agent agent, Room room, Agent employee, Cost cost, boolean notify) {
		super(agent, room, cost, notify);
		this.agent = agent;
		this.notify = notify;
	}

	@Override
	public void run() {
		if(!subtractCost()) {
			return;
		}
		room.hireAgent(employee);
		employee.setLocation(room);
		postRun();
	}

}
