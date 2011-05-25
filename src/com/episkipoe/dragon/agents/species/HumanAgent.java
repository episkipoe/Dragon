package com.episkipoe.dragon.agents.species;

import com.episkipoe.dragon.agents.Agent;

public class HumanAgent extends Agent {
	private static final long serialVersionUID = 8481436738548717616L;
	
	public HumanAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Human"; }

}
