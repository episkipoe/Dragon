package com.episkipoe.dragon.production;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentEvent;
import com.episkipoe.dragon.lairs.Lair;

public class ProductionEvent extends AgentEvent {
	private static final long serialVersionUID = 1281943906119555662L;
	private Lair from;
	private Product product;
	public ProductionEvent(Agent agent, Lair from, Product product) {
		super(agent, product.getCost().getWaitTime());
		this.from = from;
		this.product = product;
	}

	@Override
	public void run() {
		product.produce(from);
		postRun();
	}

}
