package com.episkipoe.dragon.agents.skills;

public class SneakSkill extends Skill {
	private static final long serialVersionUID = 8571567104451744693L;

	public SneakSkill() {
	}

	@Override
	public String getName() { return "Sneak"; }

	@Override
	public boolean canByDefault() { return true; }

}
