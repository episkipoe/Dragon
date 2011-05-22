package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Cost;

public class HireEvent extends Event {
	Room room;
	Agent agent;
	Cost cost;
	boolean notify;
	public HireEvent(Player player, Room room, Agent agent, Cost cost, boolean notify) {
		super(player);
		this.room = room;
		this.agent = agent;
		this.cost = cost;
		this.notify = notify;
	}

	@Override
	public void run() {
		if(!room.getLair().subtractCost(cost, notify)) {
			return;
		}
		room.hireAgent(agent);
		agent.setLocation(room);
	}

}
