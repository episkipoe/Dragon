package com.episkipoe.dragon.production;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;

public class ProductionEvent extends Event {
	private static final long serialVersionUID = 1281943906119555662L;
	private LairList kingdom;
	private Lair from;
	private Product product;
	public ProductionEvent(Agent agent, LairList kingdom, Lair from, Product product) {
		super(agent, product.getCost().getWaitTime());
		this.kingdom = kingdom;
		this.from = from;
		this.product = product;
	}

	@Override
	public void run() {
		product.produce(kingdom, from);
		postRun();
	}

}
