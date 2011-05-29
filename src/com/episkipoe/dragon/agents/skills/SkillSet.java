package com.episkipoe.dragon.agents.skills;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.episkipoe.dragon.agents.Agent;

public class SkillSet implements Serializable {
	private static final long serialVersionUID = 763966347600592241L;
	
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

	public Collection<Skill> getSkills () { return skills.values(); }
	
	public SkillSet getSkills(SkillSet required) {
		SkillSet subSet = new SkillSet();
		for(Skill s : required.getSkills()) {
			if(!hasSkill(s.getClass())) continue;
			subSet.add(getSkill(s.getClass()));
		}
		return subSet;
	}
	
	public void awardXP(SkillSet skills, int XP) {
		for(Skill s : skills.getSkills()) {
			if(!hasSkill(s.getClass())) continue;
			getSkill(s.getClass()).awardXP(XP);
		}
	}	
	
	public void applyModifiers(Agent agent) {
		
	}
	
	public boolean can(Agent agent) {
		for(Iterator<Skill> iter = skills.values().iterator() ; iter.hasNext(); ) {
			Skill s = iter.next();
			if(!agent.can(s.getClass())) return false;
		}
		return true;
	}

}
