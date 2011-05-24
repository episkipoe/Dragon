package com.episkipoe.dragon.agents.attributes;

import com.episkipoe.dragon.agents.Agent;

public class HealthAttribute extends Attribute {
	private static final long serialVersionUID = 9166390393964465300L;

	@Override
	public String getName() { return "Health"; }
	public void levelUp(Agent agent) { level += agent.getLevel(); }

	public String getStatus() { return "Healthy"; }
}
