package com.episkipoe.dragon.agents;

import java.util.ArrayList;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.classes.AgentClass;
import com.episkipoe.dragon.agents.skills.Skill;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.GUI;

public class AgentDisplay extends CommandPage {
	private static final long serialVersionUID = 8307165616738462561L;
	
	private Agent agent=null;
	public AgentDisplay() { }
	public AgentDisplay(Agent agent) { 
		this.agent = agent;
	}
	
	//TODO:  Character sheet
	@Override
	public String getCommandName() { 
		if(agent == null) return "Character sheet";
		return "View " + agent.getName(); 
	}

	private void showAgent(Agent agent) {
		GUI.text("Classes");
		for(AgentClass c : agent.getClassSet().getAgentClasses()) {
			GUI.text(c.getType() + ": " + c.getLevel());
			
		}
		GUI.text("Skills");
		for(Skill s : agent.getSkillSet().getSkills()) {
			GUI.text(s.getName() + ": " + s.get());
		}
	}
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		if(agent==null) {
			showAgent(Main.player.getPlayerAgent());
		} else {
			showAgent(agent);
		}
	}

}
