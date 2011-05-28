package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.skills.Skill;

public class FarmSkill extends Skill {
	private static final long serialVersionUID = -4170527134416266559L;

	@Override
	public String getName() { return "Farming"; }

	@Override
	public boolean canByDefault() { return true; }

}
