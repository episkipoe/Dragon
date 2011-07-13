package com.episkipoe.dragon.agents.skills;

import java.io.Serializable;

public abstract class Skill implements Serializable {
	private static final long serialVersionUID = -5162470879162188174L;
	
	public abstract String getName();
	public abstract boolean canByDefault();
	private int level=0, XP=0;
	final private void levelUp() { level++; }
	final public void awardXP(int XP) { 
		this.XP += XP;
		int nextLevelAt = 10+2*(level * level);
		if(this.XP >= nextLevelAt) levelUp();
	}
	
	public final int get() {
		return level;
	}
}
