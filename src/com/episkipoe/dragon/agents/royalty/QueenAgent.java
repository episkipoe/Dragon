package com.episkipoe.dragon.agents.royalty;

import com.episkipoe.dragon.agents.Agent;

public class QueenAgent extends Agent {
	private static final long serialVersionUID = -8712339479640851476L;
	
	public QueenAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Queen"; }

}
