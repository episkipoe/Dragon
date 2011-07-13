package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;

public class GrainTreasure extends ProductionTreasure {
	private static final long serialVersionUID = -7500340135838039706L;
	public GrainTreasure() { this.qty = 1; } 
	public GrainTreasure(int qty) { this.qty = qty; } 

	@Override public String getType() { return "Grain"; }
	@Override public String getProductionName() { return "Farm grain"; }
	@Override public int getValue(Agent agent) { return (1 * qty); }
	
	public Product getProduct(int roomLevel) {
		Product grain = new Product(new GrainTreasure(2+roomLevel), 4);
		grain.getCost().increaseWaitTime(5);
		SkillSet skills = new SkillSet(new FarmSkill());
		grain.setSkillRequirements(skills);
		return grain;
	}
		
}
