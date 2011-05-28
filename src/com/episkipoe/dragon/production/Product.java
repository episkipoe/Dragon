package com.episkipoe.dragon.production;

import java.io.Serializable;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.agents.skills.SkillUtils;
import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.treasure.Treasure;
import com.episkipoe.dragon.treasure.TreasureList;

/**
 *  A recipe for the creation of goods in a {@link TreasureList}
 *  The {@link Cost} will be subtracted from the {@link LairList} 
 *
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 5792458099565230054L;
	private Cost requires;
	private TreasureList produces;
	private SkillSet skills=null;
	int difficulty;
	public Product(Cost requires, TreasureList produces, int difficulty) {
		this.requires = requires;
		this.produces = produces;
		this.skills = new SkillSet();
		this.difficulty = difficulty;
	}
	public Product(TreasureList produces, int difficulty) {
		this.requires = new Cost();
		this.produces = produces;
		this.skills = new SkillSet();
		this.difficulty = difficulty;
	}
	public Product(Treasure produces, int difficulty) {
		this.requires = new Cost();
		this.produces = new TreasureList(produces);
		this.skills = new SkillSet();
		this.difficulty = difficulty;
	}
	public void setSkillRequirements(SkillSet skills) {
		this.skills = skills;
	}
	public Cost getCost() { return requires; }
	public TreasureList getProduces() { return produces; }
	public boolean skillCheck(Agent agent) {
		//TODO Award Skill XP for the attempt
		return SkillUtils.skillCheck(agent, skills, difficulty);
	}
	public void produce(Lair from) {
		if(!CommerceUtils.canAfford(from.getKingdom(), requires)) return;
		CommerceUtils.subtractCost(from, requires);
		TreasureList destination = CommerceUtils.getNearestStore(from);
		destination.add(produces);
	}
}
