package com.episkipoe.dragon.agents.skills;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.episkipoe.dragon.agents.skills.Skill;

public class SkillSet {
	public SkillSet() {
		skills = new TreeMap<String,Skill>();
	}
	
	private Map<String,Skill> skills;
	public void add(Skill s) { skills.put(s.getName(), s); }
	public void setSkill(String type, Skill s) { skills.put(type,s); }
	public Skill getSkill(String type) { return skills.get(type); }
	public boolean hasSkill(String type) { return skills.containsKey(type); }
	public int getSkillLevel(String type) {
		if(!hasSkill(type)) return 0;
		return getSkill(type).level;
	}
	public int numSkills() { return skills.size(); }

	public Collection<Skill> getSkills () { return skills.values(); }	
}
