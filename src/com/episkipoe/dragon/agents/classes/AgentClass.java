package com.episkipoe.dragon.agents.classes;

import java.io.Serializable;
import java.util.Collection;

import com.episkipoe.dragon.agents.attributes.Attribute;
import com.episkipoe.dragon.agents.skills.Skill;

public abstract class AgentClass implements Serializable {
	private static final long serialVersionUID = 3613043874803999743L;

	protected AgentClass (int level) {
		for(int i=0; i < level; i++) levelUp();
	}
	
	/*
	 * Methods a subclass must override
	 */
	abstract public String getType();
	
	/*
	 * Methods a subclass should override
	 */
	//Attributes
	public Collection<Class<? extends Attribute>> getPrimaryAttributes() { return null; }
	public Collection<Class<? extends Attribute>> getSecondaryAttributes() { return null; }
	public int getAttributeModifier(Class<? extends Attribute> attribute) { 
		if(getPrimaryAttributes() != null && getPrimaryAttributes().contains(attribute)) { return getLevel() * 5; }
		if(getSecondaryAttributes() != null && getSecondaryAttributes().contains(attribute)) { return getLevel() * 2; }
		return 0;
	}
	
	//Skills
	public Collection<Class<? extends Skill>> getPrimarySkills() { return null; }
	public Collection<Class<? extends Skill>> getSecondarySkills() { return null; }
	public int getSkillModifier(Class<? extends Skill> skill) { 
		if(getPrimarySkills() != null && getPrimarySkills().contains(skill)) { return getLevel() * 5; }
		if(getSecondarySkills() != null && getSecondarySkills().contains(skill)) { return getLevel() * 2; }
		return 0;
	}
	public boolean enablesSkill(Class<? extends Skill> skill) { 
		if(getPrimarySkills() != null && getPrimarySkills().contains(skill)) { return true; }
		return false; 
	}
	
	/**
	 * Called after new level is applied, any specific benefits should occur here
	 */
	public void postLevelUp() { }
	
	/*
	 *  Utility methods
	 */
	int level=0, XP=0;
	final public int getLevel() { return level; }
	final private void levelUp() {
		level++;
		postLevelUp();
	}
	final public void awardXP(int XP) { 
		this.XP += XP;
		int nextLevelAt = 10+2*(level * level);
		if(this.XP >= nextLevelAt) levelUp();
	}	
}
