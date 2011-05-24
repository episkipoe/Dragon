package com.episkipoe.dragon.production;

import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;

public class ProductionEvent extends Event {
	private LairList kingdom;
	private Lair from;
	private Product product;
	public ProductionEvent(LairList kingdom, Lair from, Product product) {
		this.kingdom = kingdom;
		this.from = from;
		this.product = product;
	}

	@Override
	public void run() {
		product.produce(kingdom, from);
	}

}
