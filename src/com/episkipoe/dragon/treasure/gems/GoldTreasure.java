package com.episkipoe.dragon.treasure.gems;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.treasure.MineSkill;


public class GoldTreasure extends ProductionTreasure {
	private static final long serialVersionUID = 1856974886586511127L;
	
	public GoldTreasure() { super(); }
	public GoldTreasure (int qty) { this.qty = qty; }
	
	@Override public String getType() { return "Gold"; }
	@Override public String getProductionName() { return "Mine for gold"; }
	@Override public int getValue(Agent agent) { return qty; }
	
	@Override public Product getProduct(int roomLevel) {
		Product gold = new Product(new GoldTreasure(5+5*roomLevel), 5);
		gold.getCost().increaseWaitTime(10+roomLevel);
		SkillSet skills = new SkillSet(new MineSkill());
		gold.setSkillRequirements(skills);
		return gold;
	}
}

