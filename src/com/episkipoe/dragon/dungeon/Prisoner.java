package com.episkipoe.dragon.dungeon;

import java.io.Serializable;

import com.episkipoe.dragon.agents.Agent;

public class Prisoner implements Serializable {
	private static final long serialVersionUID = 2571040979218196889L;
	
	Agent agent;
	public Prisoner(Agent agent) {
		this.agent = agent;
	}
	
}
