package com.episkipoe.dragon.agents.royalty;

import com.episkipoe.dragon.agents.Agent;

public class KingAgent extends Agent {
	private static final long serialVersionUID = 6887847709907089975L;
	
	public KingAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "King"; }

}
