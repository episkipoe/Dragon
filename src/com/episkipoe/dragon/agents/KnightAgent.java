package com.episkipoe.dragon.agents;

public class KnightAgent extends Agent {
	private static final long serialVersionUID = -612795873276084742L;
	
	public KnightAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Knight"; } 
}
