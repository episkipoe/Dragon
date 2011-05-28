package com.episkipoe.dragon.rooms;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.RoomCommerceCommand;
import com.episkipoe.dragon.commerce.Cost;

public class HireCommand extends RoomCommerceCommand {
	private static final long serialVersionUID = 2357730369227472014L;
	Agent agent;
	public HireCommand(Room room, Agent agent, Cost cost) {
		super(room, cost);
		this.agent = agent;
	}

	public void onClick(View v) {
		new HireEvent(Main.player.getPlayerAgent(), room, agent, cost, true);
	}

	@Override
	public String getCommandName() { return "Hire a " + agent.getType() + " to work here"; }
	public String getDescription() { return cost.toString(); }

}
