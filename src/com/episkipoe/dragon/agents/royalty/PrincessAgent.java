package com.episkipoe.dragon.agents.royalty;

import com.episkipoe.dragon.agents.Agent;

public class PrincessAgent extends Agent {
	private static final long serialVersionUID = 8112335832119423813L;
	
	public PrincessAgent(int level) {
		super(level);
	}


	@Override
	public String getType() { return "Princess"; } 

}
