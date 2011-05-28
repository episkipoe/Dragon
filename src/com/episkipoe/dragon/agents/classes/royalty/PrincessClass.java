package com.episkipoe.dragon.agents.classes.royalty;

import com.episkipoe.dragon.agents.classes.AgentClass;

public class PrincessClass extends AgentClass {
	private static final long serialVersionUID = 8112335832119423813L;
	
	public PrincessClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Princess"; } 

}
