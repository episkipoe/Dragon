package com.episkipoe.dragon.production;

import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.treasure.TreasureList;

public class Product {
	private Cost requires;
	private TreasureList produces;
	public Product(Cost requires, TreasureList produces) {
		this.requires = requires;
		this.produces = produces;
	}
	public Product(TreasureList produces) {
		this.requires = new Cost();
		this.produces = produces;
	}
	public Cost getCost() { return requires; }
	public TreasureList getProduces() { return produces; }
	public void produce(LairList kingdom, Lair from) {
		if(!CommerceUtils.canAfford(kingdom, requires)) return;
		CommerceUtils.subtractCost(from, requires);
		TreasureList destination = CommerceUtils.getNearestStore(from);
		System.out.println("put in " + destination.toString());
		destination.add(produces);
	}
}
