package com.episkipoe.dragon.agents.skills;

import java.util.Random;

public class SkillUtils {
	public static boolean skillCheck(SkillSet skills, int difficulty) {
		Random rnd = new Random();
		int value = rnd.nextInt((int)skills.averageSkill());
		value+=skills.totalModifiers();
		return (value>difficulty);
	}
	public static boolean skillCheck(SkillSet a, SkillSet b) {
		Random rnd = new Random();
		int aValue = rnd.nextInt((int)a.averageSkill());
		aValue+=a.totalModifiers();
		int bValue = rnd.nextInt((int)b.averageSkill());
		bValue+=b.totalModifiers();
		return (aValue>bValue);
	}
}
