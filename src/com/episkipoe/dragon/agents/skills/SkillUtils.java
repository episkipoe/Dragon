package com.episkipoe.dragon.agents.skills;

import java.util.Random;

import com.episkipoe.dragon.agents.Agent;

public class SkillUtils {
	private static boolean skillCheck(SkillSet skills, int difficulty) {
		Random rnd = new Random();
		int avgSkill = (int)skills.averageSkill();
		if(difficulty<=20) {
			int luck = rnd.nextInt(20);
			if(luck==0) return false;
			if(luck==19) return true;
		}
		if(avgSkill<=0) {
			return false;
		}
		int value = rnd.nextInt(avgSkill);
		return (value>difficulty);
	}
	
	private static void useSkills(Agent agent, SkillSet agentSkills, int difficulty, SkillSet skillsUsed) {
		int avgSkill = (int)agentSkills.averageSkill();
		if(difficulty>(avgSkill+20)) return ; //Trying something too hard 
		agent.getSkillSet().awardXP(skillsUsed, 1);
	}

	//TODO:  level in required indicates relative contribution 
	public static boolean skillCheck(Agent agent, SkillSet required, int difficulty) {
		if(!required.can(agent)) return false;
		SkillSet agentSkills = agent.getSkillSet().getSkills(required);
		useSkills(agent, agentSkills, difficulty, required);
		agentSkills.applyModifiers(agent);
		return skillCheck(agentSkills, difficulty);
	}
	
	public static boolean skillCheck(Agent agent, Class<? extends Skill> required, int difficulty) {
		try {
			SkillSet skills = new SkillSet(required.newInstance());
			return skillCheck(agent, skills, difficulty);
		} catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @return true if a beats b
	 */
	public static boolean skillCheck(Agent agentA, SkillSet skillsA, Agent agentB, SkillSet skillsB) {
		if(!skillsA.can(agentA)) return false;
		if(!skillsB.can(agentB)) return true;
		
		SkillSet agentASkills = agentA.getSkillSet().getSkills(skillsA);
		SkillSet agentBSkills = agentA.getSkillSet().getSkills(skillsB);
		
		Random rnd = new Random();
		int aAvg = (int)skillsA.averageSkill();
		int bAvg = (int)skillsB.averageSkill();
		useSkills(agentA, agentASkills, bAvg, skillsA);
		useSkills(agentB, agentBSkills, aAvg, skillsB);
		
		agentASkills.applyModifiers(agentA);
		agentBSkills.applyModifiers(agentB);
		
		int aValue=0, bValue=0;
		if(aAvg>0) aValue = rnd.nextInt(aAvg);
		if(bAvg>0) bValue = rnd.nextInt(bAvg);
		
		return (aValue>bValue);
	}
}
