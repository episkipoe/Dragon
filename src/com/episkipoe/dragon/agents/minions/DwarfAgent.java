package com.episkipoe.dragon.agents.minions;


public class DwarfAgent extends MinionAgent {
	private static final long serialVersionUID = -1746273078372318869L;
	public DwarfAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Dwarf"; }

}
