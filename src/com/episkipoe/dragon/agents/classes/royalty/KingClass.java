package com.episkipoe.dragon.agents.classes.royalty;

import com.episkipoe.dragon.agents.Agent;

public class KingClass extends Agent {
	private static final long serialVersionUID = 6887847709907089975L;
	
	public KingClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "King"; }

}
