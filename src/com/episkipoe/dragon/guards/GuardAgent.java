package com.episkipoe.dragon.guards;

import com.episkipoe.dragon.agents.Agent;

public class GuardAgent extends Agent {
	public GuardAgent(int level) {
		super(level);
	}

	private static final long serialVersionUID = 5440848237849234470L;

	@Override
	public String getType() { return "Guard"; }

}
