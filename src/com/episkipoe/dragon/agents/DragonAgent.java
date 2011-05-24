package com.episkipoe.dragon.agents;

public class DragonAgent extends Agent {
	public DragonAgent(int level) {
		super(level);
	}

	private static final long serialVersionUID = 9210869451727458206L;

	@Override
	public String getType() { return "Dragon"; } 
	
}
