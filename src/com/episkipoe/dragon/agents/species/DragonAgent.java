package com.episkipoe.dragon.agents.species;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.FearSkill;
import com.episkipoe.dragon.agents.skills.Skill;
import com.episkipoe.dragon.agents.skills.SneakSkill;

public class DragonAgent extends Agent {
	public DragonAgent(int level) {
		super(level);
	}

	private static final long serialVersionUID = 9210869451727458206L;

	@Override
	public String getType() { return "Dragon"; } 
	
	public boolean can(Class<? extends Skill> type) {
		if (type == FearSkill.class) { return true; }
		if (type == SneakSkill.class) { return false; }
		return super.can(type);
	}
	
}
