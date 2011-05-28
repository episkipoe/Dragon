package com.episkipoe.dragon.agents.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.episkipoe.dragon.agents.skills.BraverySkill;
import com.episkipoe.dragon.agents.skills.Skill;

public class KnightClass extends AgentClass {
	private static final long serialVersionUID = -612795873276084742L;
	
	public KnightClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Knight"; }

	public Collection<Class<? extends Skill>> getPrimarySkills() { 
		List<Class<? extends Skill>> skills = new ArrayList<Class<? extends Skill>>();
		skills.add(BraverySkill.class);
		return skills; 
	}
}
