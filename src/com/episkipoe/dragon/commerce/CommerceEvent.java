package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.Cost;

public abstract class CommerceEvent extends Event {
	protected Room room;
	protected Cost cost;
	protected boolean notify;
	public CommerceEvent(Player player, Room room, Cost cost, boolean notify) {
		super(player);
		this.room = room;
		this.cost = cost;	
		this.notify = notify;
	}

	protected boolean subtractCost() {
		LairList kingdom = room.getLair().getKingdom();
		return CommerceUtils.subtractCost(kingdom, cost);
	}
}
