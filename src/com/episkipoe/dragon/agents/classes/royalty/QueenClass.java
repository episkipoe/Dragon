package com.episkipoe.dragon.agents.classes.royalty;

import com.episkipoe.dragon.agents.classes.AgentClass;
import com.episkipoe.dragon.agents.skills.DiplomacySkill;
import com.episkipoe.dragon.agents.skills.Skill;

public class QueenClass extends AgentClass {
	private static final long serialVersionUID = -8712339479640851476L;
	
	public QueenClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Queen"; }

	public int getSkillModifier(Class<? extends Skill> skill) { 
		if(skill==DiplomacySkill.class) return 5*getLevel();
		return 0; 
	}
}
