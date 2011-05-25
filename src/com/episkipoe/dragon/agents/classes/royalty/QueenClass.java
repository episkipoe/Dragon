package com.episkipoe.dragon.agents.classes.royalty;

import com.episkipoe.dragon.agents.Agent;

public class QueenClass extends Agent {
	private static final long serialVersionUID = -8712339479640851476L;
	
	public QueenClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Queen"; }

}
