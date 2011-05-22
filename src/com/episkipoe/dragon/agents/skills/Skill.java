package com.episkipoe.dragon.agents.skills;

import java.io.Serializable;

public abstract class Skill implements Serializable {
	private static final long serialVersionUID = -5162470879162188174L;
	
	public abstract String getName();
	int level;
}
