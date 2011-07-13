package com.episkipoe.dragon.production.food;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.treasure.TreasureList;

public class BeefTreasure extends ProductionTreasure {
	private static final long serialVersionUID = 8673303730490818810L;

	public BeefTreasure() { this.qty = 1; }
	public BeefTreasure(int qty) { this.qty = qty; }
	
	@Override public String getType() { return "Beef"; }
	@Override public String getProductionName() { return "Slaughter Cow"; }
	@Override public int getValue(Agent agent) { return (30 * qty); }
	
	@Override public Product getProduct(int roomLevel) {
		TreasureList requires = new TreasureList();
		requires.add(new CowTreasure());
		Cost cost = new Cost(requires, 3);
		TreasureList produces = new TreasureList();
		produces.add(new BeefTreasure(1+roomLevel));
		Product beef = new Product(cost, produces, 5);
		SkillSet skills = new SkillSet(new FarmSkill());
		beef.setSkillRequirements(skills);
		return beef;
	}

}
