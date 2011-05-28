package com.episkipoe.dragon.lairs;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentEvent;
import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.commerce.Cost;

public class BuildLairEvent extends AgentEvent {
	private static final long serialVersionUID = 2392041408331651081L;
	private LairList kingdom;
	private Lair lair;
	private Cost cost;
	private boolean notify;
	BuildLairEvent (Agent agent, LairList kingdom, Lair lair, Cost cost, boolean notify) {
		super(agent, cost.getWaitTime());
		this.kingdom = kingdom;
		this.lair = lair;
		this.cost = cost;
		this.notify = notify;
	}
	@Override
	public void run() {
		if(!CommerceUtils.subtractCost(lair, cost)) return;
		kingdom.addLair(lair);
		if(notify) Main.player.popupNotify("Lair construction complete");
		Main.player.refresh();
		postRun();
	}

}
