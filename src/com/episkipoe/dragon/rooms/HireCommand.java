package com.episkipoe.dragon.rooms;

import android.view.View;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.CommerceCommand;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.events.EventScheduler;

public class HireCommand extends CommerceCommand {
	private static final long serialVersionUID = 2357730369227472014L;
	Agent agent;
	public HireCommand(Room room, Agent agent, Cost cost) {
		super(room, cost);
		this.agent = agent;
	}

	public void onClick(View v) {
		HireEvent event = new HireEvent(room, agent, cost, true);
		EventScheduler.schedule(event, cost.getWaitTime());
	}

	@Override
	public String getCommandName() { return "Hire a " + agent.getType() + " to work here"; }
	public String getDescription() { return cost.toString(); }

}
