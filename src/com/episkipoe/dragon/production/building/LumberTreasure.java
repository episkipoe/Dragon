package com.episkipoe.dragon.production.building;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.treasure.MineSkill;

public class LumberTreasure extends ProductionTreasure {
	private static final long serialVersionUID = -7722486729926976350L;

	public LumberTreasure() { this.qty = 1; }
	public LumberTreasure(int qty) { this.qty = qty; }

	@Override public String getType() { return "Lumber"; }
	@Override public String getProductionName() { return "Chop trees for lumber"; }
	@Override public int getValue(Agent agent) { return (2 * qty); }

	public Product getProduct(int roomLevel) {
		Product lumber = new Product(new LumberTreasure(1+2*roomLevel), 8);
		lumber.getCost().increaseWaitTime(8);
		SkillSet skills = new SkillSet(new MineSkill());
		lumber.setSkillRequirements(skills);
		return lumber;
	}

}
