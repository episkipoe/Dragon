package com.episkipoe.dragon.agents.classes.royalty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.episkipoe.dragon.agents.classes.AgentClass;
import com.episkipoe.dragon.agents.skills.DiplomacySkill;
import com.episkipoe.dragon.agents.skills.Skill;

public class KingClass extends AgentClass {
	private static final long serialVersionUID = 6887847709907089975L;
	
	public KingClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "King"; }

	public Collection<Class<? extends Skill>> getPrimarySkills() { 
		List<Class<? extends Skill>> skills = new ArrayList<Class<? extends Skill>>();
		skills.add(DiplomacySkill.class);
		return skills; 
	}
	public int getSkillModifier(Class<? extends Skill> skill) { 
		if(skill==DiplomacySkill.class) return 5*getLevel();
		return 0; 
	}
}
