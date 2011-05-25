package com.episkipoe.dragon.agents;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commands.CommandPage;

public class AgentDisplay extends CommandPage {
	private static final long serialVersionUID = 8307165616738462561L;
	
	Agent agent;
	public AgentDisplay(Agent agent) {
		this.agent = agent;
	}
	//TODO:  Character sheet
	@Override
	public String getCommandName() { 
		if(agent == Main.player.getPlayerAgent()) return "Character sheet";
		return "View " + agent.getName(); 
	}

}
