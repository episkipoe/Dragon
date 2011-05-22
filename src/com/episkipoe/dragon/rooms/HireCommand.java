package com.episkipoe.dragon.rooms;

import android.view.View;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Cost;

public class HireCommand extends Command {
	Room room;
	Agent agent;
	Cost cost;
	public HireCommand(Player player, Room room, Agent agent, Cost cost) {
		super(player);
		this.room = room;
		this.cost = cost;
	}

	public void onClick(View v) {
		HireEvent event = new HireEvent(player, room, agent, cost, true);
		event.run();
	}

	@Override
	public String getCommandName() { return "Hire a " + agent.getType() + " to work here"; }
	public String getDescription() { return cost.toString(); }

}
