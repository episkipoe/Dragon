package com.episkipoe.dragon.agents.skills;

import java.util.Random;

import com.episkipoe.dragon.agents.Agent;

public class SkillUtils {
	public static boolean skillCheck(SkillSet skills, int difficulty) {
		Random rnd = new Random();
		int avgSkill = (int)skills.averageSkill();
		if(avgSkill<=0) return false;
		int value = rnd.nextInt(avgSkill);
		return (value>difficulty);
	}
	public static boolean skillCheck(Agent agent, SkillSet required, int difficulty) {
		SkillSet agentSkills = agent.getSkillSet().getSkills(required);
		agentSkills.applyModifiers(agent);
		return skillCheck(agentSkills, difficulty);
	}
	public static boolean skillCheck(Agent agent, Class<? extends Skill> required, int difficulty) {
		int skillLevel = agent.getSkillSet().getSkillLevel(required);
		if(skillLevel<=0) return false;
		Random rnd = new Random();
		int value = rnd.nextInt(skillLevel);
		return (value>difficulty);
	}
	public static boolean skillCheck(SkillSet a, SkillSet b) {
		//TODO  modifiers for agent vs agent
		Random rnd = new Random();
		int aAvg = (int)a.averageSkill();
		int aValue=0;
		if(aAvg>0) aValue = rnd.nextInt(aAvg);
		int bAvg = (int)b.averageSkill();
		int bValue = 0;
		if(bAvg>0) bValue = rnd.nextInt(bAvg);
		return (aValue>bValue);
	}
}
