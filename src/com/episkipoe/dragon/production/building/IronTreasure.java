package com.episkipoe.dragon.production.building;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.treasure.MineSkill;

public class IronTreasure extends ProductionTreasure {
	private static final long serialVersionUID = -7254920043982097635L;

	public IronTreasure() { qty= 1; }
	public IronTreasure(int qty) { this.qty= qty; }

	@Override public String getType() { return "Iron" ; }
	@Override public String getProductionName() { return "Mine for iron"; }
	@Override public int getValue(Agent agent) { return (3 * qty); }

	@Override public Product getProduct(int roomLevel) {
		Product iron = new Product(new IronTreasure(1+roomLevel), 8);
		iron.getCost().increaseWaitTime(8);
		SkillSet skills = new SkillSet(new MineSkill());
		iron.setSkillRequirements(skills);
		return iron;
	}
	
}
