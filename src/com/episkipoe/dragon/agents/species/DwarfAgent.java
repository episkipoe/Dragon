package com.episkipoe.dragon.agents.species;

import com.episkipoe.dragon.agents.Agent;

public class DwarfAgent extends Agent {
	private static final long serialVersionUID = -1746273078372318869L;
	public DwarfAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Dwarf"; }

}
