package com.episkipoe.dragon.agents;

import com.episkipoe.dragon.events.Event;

public abstract class AgentEvent extends Event {
	private static final long serialVersionUID = 7191701944998116627L;
	protected Agent agent;
	public AgentEvent(Agent agent, int delay) {
		super(agent.getEvents(), delay);
		this.agent = agent;
	}

}
