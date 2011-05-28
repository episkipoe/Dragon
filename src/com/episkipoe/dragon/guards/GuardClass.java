package com.episkipoe.dragon.guards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.episkipoe.dragon.agents.classes.AgentClass;
import com.episkipoe.dragon.agents.skills.PerceptionSkill;
import com.episkipoe.dragon.agents.skills.Skill;

public class GuardClass extends AgentClass {
	private static final long serialVersionUID = 5440848237849234470L;
	
	public GuardClass(int level) {
		super(level);
	}

	@Override
	public String getType() { return "Guard"; }

	public Collection<Class<? extends Skill>> getPrimarySkills() { 
		List<Class<? extends Skill>> skills = new ArrayList<Class<? extends Skill>>();
		skills.add(PerceptionSkill.class);
		return skills; 
	}

}
