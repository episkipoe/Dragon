package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.treasure.TreasureList;

public class AleTreasure extends ProductionTreasure {
	private static final long serialVersionUID = 2239854700589973679L;

	public AleTreasure() { this.qty = 1; }
	public AleTreasure(int qty) { this.qty = qty; }
	
	public String getType() { return "Ale"; }
	public String getProductionName() { return "Brew Ale"; }
	public int getValue(Agent agent) { return (10 * qty); }
	
	public Product getProduct(int roomLevel) {
		if(roomLevel<0) return null;
		TreasureList requires = new TreasureList();
		requires.add(new GrainTreasure());
		Cost cost = new Cost(requires, 3);
		TreasureList produces = new TreasureList();
		produces.add(new AleTreasure(1+roomLevel));
		Product ale = new Product(cost, produces, 5);
		SkillSet skills = new SkillSet(new BrewSkill());
		ale.setSkillRequirements(skills);
		return ale;
	}

}
