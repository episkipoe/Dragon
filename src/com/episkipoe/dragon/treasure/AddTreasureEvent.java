package com.episkipoe.dragon.treasure;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.events.Event;

public class AddTreasureEvent extends Event {
	private static final long serialVersionUID = 4572554619595924071L;

	boolean notify=false;

	TreasureList treasureList;
	Treasure treasure;
	public AddTreasureEvent(Agent agent, TreasureList treasureList, Treasure treasure, int delay) {
		super(agent, delay);
		this.treasureList = treasureList;
		this.treasure = treasure;
	}
	
	public AddTreasureEvent(Agent agent, TreasureList treasureList, Treasure treasure, int delay, boolean notify) {
		super(agent, delay);
		this.treasureList = treasureList;
		this.treasure = treasure;
	}

	@Override
	public void run() {
		if(treasureList==null) treasureList = agent.getInventory();
		if(treasureList==null) {
			String message = "There is nowhere to put the " + treasure.getType();
			Main.player.popupNotify(message);
			postRun();
			return;
		}
		
		treasureList.add(treasure);
		if(notify) {
			String message = treasure.qty + " " + treasure.getType() + " have been acquired";
			Main.player.popupNotify(message);
		}
		postRun();
	}
}
