package com.episkipoe.dragon.treasure;

import com.episkipoe.dragon.agents.skills.Skill;

public class MineSkill extends Skill {
	private static final long serialVersionUID = 4999126495501323650L;

	@Override
	public String getName() { return "Mining"; }

	@Override
	public boolean canByDefault() { return true; }

}
