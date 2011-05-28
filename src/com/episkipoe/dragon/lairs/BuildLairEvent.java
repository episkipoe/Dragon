package com.episkipoe.dragon.lairs;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.events.GUIHandler;

public class BuildLairEvent extends Event {
	private LairList kingdom;
	private Lair lair;
	private Cost cost;
	private boolean notify;
	BuildLairEvent (LairList kingdom, Lair lair, Cost cost, boolean notify) {
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
		Main.player.guiHandler().sendEmptyMessage(GUIHandler.REFRESH);
	}

}
