package com.episkipoe.dragon.rooms;

import android.view.View;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.CommerceCommand;
import com.episkipoe.dragon.events.EventScheduler;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Cost;

public class HireCommand extends CommerceCommand {
	Agent agent;
	public HireCommand(Player player, Room room, Agent agent, Cost cost) {
		super(player, room, cost);
		this.agent = agent;
	}

	public void onClick(View v) {
		HireEvent event = new HireEvent(player, room, agent, cost, true);
		EventScheduler.schedule(event, cost.getWaitTime());
	}

	@Override
	public String getCommandName() { return "Hire a " + agent.getType() + " to work here"; }
	public String getDescription() { return cost.toString(); }

}
