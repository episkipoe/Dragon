package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;

public class MushroomTreasure extends ProductionTreasure {
	private static final long serialVersionUID = 1L;
	
	public MushroomTreasure() { this.qty = 1; }
	public MushroomTreasure(int qty) { this.qty = qty; }

	public String getType() { return "Mushroom"; }
	public String getProductionName() { return "Gather Mushrooms"; }
	public int getValue(Agent agent) { return (1 * qty); }

	public Product getProduct(int roomLevel) {
		if(roomLevel<0) return null;
		Product product = new Product(new MushroomTreasure(1+(2*roomLevel)), 6);
		product.getCost().increaseWaitTime(4+roomLevel);
		SkillSet skills = new SkillSet(new FarmSkill());
		product.setSkillRequirements(skills);
		return product;
	}
	
}
