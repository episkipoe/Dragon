package com.episkipoe.dragon.agents.skills;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import com.episkipoe.dragon.agents.skills.Skill;

public class SkillSet {
	public SkillSet() {
		resetSkills();
	}
	public SkillSet(Skill s) {
		resetSkills();
		add(s);
	}
	public SkillSet(Collection<Skill> sList) {
		resetSkills();
		for(Skill s: sList) add(s);
	}
	
	public void resetSkills() {
		skills = new HashMap<Class<? extends Skill>,Skill>();
	}
	
	private Map<Class<? extends Skill>, Skill> skills;
	public void add(Skill s) { skills.put(s.getClass(), s); }
	public Skill getSkill(Class<? extends Skill> s) { return skills.get(s); }
	public boolean hasSkill(Class<? extends Skill> s) { return skills.containsKey(s); }
	public int getSkillLevel(Class<? extends Skill> s) {
		if(!hasSkill(s)) return 0;
		return getSkill(s).level;
	}
	public int numSkills() { return skills.size(); }
	public int totalSkill() { 
		int total=0;
		for(Skill s : getSkills()) total += s.level;
		return total;
	}
	public double averageSkill() {
		if(numSkills() <=0) return 0.0;
		double total=0;
		for(Skill s : getSkills()) total += s.level;
		total/=numSkills();
		return total;
	}
	public int totalModifiers() { return 0; }

	public Collection<Skill> getSkills () { return skills.values(); }	
}
