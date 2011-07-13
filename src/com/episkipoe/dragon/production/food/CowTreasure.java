package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;

public class CowTreasure extends ProductionTreasure {
	private static final long serialVersionUID = 4662847486291595352L;

	public CowTreasure() { this.qty = 1; } 
	public CowTreasure(int qty) { this.qty = qty; } 

	@Override public String getType() { return "Cow"; }
	@Override public String getProductionName() { return "Raise Cows"; }
	@Override public int getValue(Agent agent) { return (10 * qty); }
	
	public Product getProduct(int roomLevel) {
		Product cow = new Product(new CowTreasure(1+2*roomLevel), 12);
		cow.getCost().increaseWaitTime(8);
		SkillSet skills = new SkillSet(new FarmSkill());
		cow.setSkillRequirements(skills);
		return cow;
	}
	
}
