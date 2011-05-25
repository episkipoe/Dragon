package com.episkipoe.dragon.agents.skills;

import java.io.Serializable;

public abstract class Skill implements Serializable {
	private static final long serialVersionUID = -5162470879162188174L;
	
	public abstract String getName();
	public abstract boolean canByDefault();
	int level=0;
	int xp=0;
	
	public final int get() {
		return level;
	}
}
