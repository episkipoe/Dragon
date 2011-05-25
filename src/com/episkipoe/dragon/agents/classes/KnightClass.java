package com.episkipoe.dragon.agents.classes;

import com.episkipoe.dragon.agents.Agent;

public class KnightClass extends Agent {
	private static final long serialVersionUID = -612795873276084742L;
	
	public KnightClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Knight"; } 
}
