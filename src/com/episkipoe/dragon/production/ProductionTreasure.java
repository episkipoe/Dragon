package com.episkipoe.dragon.production;

import com.episkipoe.dragon.treasure.Treasure;

public abstract class ProductionTreasure extends Treasure {
	private static final long serialVersionUID = -7002645547129650734L;
	
	abstract public String getProductionName();
	abstract public Product getProduct(int roomLevel) ;
	final public ProductionCommand getProductionCommand(ProductionRoom room) {
		return new ProductionCommand(room, getProduct(room.getLevel()), getProductionName());
	}

}
