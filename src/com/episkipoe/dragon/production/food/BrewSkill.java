package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.skills.Skill;

public class BrewSkill extends Skill {
	private static final long serialVersionUID = 2641540870093585107L;

	@Override
	public String getName() { return "Brewing"; }

	@Override
	public boolean canByDefault() { return true; } 

}
