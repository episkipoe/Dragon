package com.episkipoe.dragon.agents;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

public class AgentDisplay extends CommandPage {
	Agent agent;
	public AgentDisplay(Player player, Agent agent) {
		super(player);
		this.agent = agent;
	}

	@Override
	public String getCommandName() { return "View stats of " + agent.getName(); }

}
