package com.episkipoe.dragon.treasure.gems;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionTreasure;
import com.episkipoe.dragon.treasure.MineSkill;

public class DiamondTreasure extends ProductionTreasure {

	private static final long serialVersionUID = 1026116556376286904L;
	
	public DiamondTreasure() { qty = 1; }
	public DiamondTreasure(int qty) { this.qty = qty; }

	@Override public String getType() { return "Diamond"; }
	@Override public String getProductionName() { return "Mine for diamonds"; }
	@Override public int getValue(Agent agent) { return (100 * qty); }
	@Override public Product getProduct(int roomLevel) {
		int produced = 1+(roomLevel / 2);
		Product product = new Product(new DiamondTreasure(produced), 5);
		product.getCost().increaseWaitTime(10+roomLevel);
		SkillSet skills = new SkillSet(new MineSkill());
		product.setSkillRequirements(skills);
		return product;
	}

}
