package com.episkipoe.dragon.agents.attributes;

import java.io.Serializable;

import com.episkipoe.dragon.agents.Agent;

public abstract class Attribute implements Serializable {
	private static final long serialVersionUID = -8938526322206147465L;
	
	public abstract String getName();
	protected int level;
	
	public void levelUp(Agent agent) { level++; }
	public int get() { return level; }
}
