package com.episkipoe.dragon.agents.classes.royalty;

import com.episkipoe.dragon.agents.Agent;

public class PrincessClass extends Agent {
	private static final long serialVersionUID = 8112335832119423813L;
	
	public PrincessClass(int level) {
		super(level);
	}


	@Override
	public String getType() { return "Princess"; } 

}
