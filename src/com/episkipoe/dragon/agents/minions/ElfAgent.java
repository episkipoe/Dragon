package com.episkipoe.dragon.agents.minions;

public class ElfAgent extends MinionAgent {
	private static final long serialVersionUID = -1746273078372318869L;
	
	public ElfAgent(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Elf"; }

}
