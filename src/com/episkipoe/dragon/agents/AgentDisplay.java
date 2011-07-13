package com.episkipoe.dragon.agents;

import java.util.ArrayList;

import android.view.ViewGroup;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.attributes.Attribute;
import com.episkipoe.dragon.agents.classes.AgentClass;
import com.episkipoe.dragon.agents.skills.Skill;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.GUI;
import com.episkipoe.dragon.treasure.TreasureDisplay;

public class AgentDisplay extends CommandPage {
	private static final long serialVersionUID = 8307165616738462561L;
	
	private Agent agent=null;
	public AgentDisplay() { 
		agent = Main.player.getPlayerAgent();
	}
	public AgentDisplay(Agent agent) { 
		this.agent = agent;
	}
	
	@Override public String getCommandName() { 
		if(agent == null) return "Character sheet";
		return "View " + agent.getName(); 
	}

	private void showAgent(ViewGroup layout, Agent agent) {
		layout.addView(GUI.text(agent.getDescription()));
		layout.addView(GUI.text("Classes"));
		for(AgentClass c : agent.getClassSet().getAgentClasses()) {
			layout.addView(GUI.text(c.getType() + ": " + c.getLevel()));
		}
		layout.addView(GUI.text("Attributes"));
		for(Attribute a : agent.getAttributeSet().getAttributes()) {
			layout.addView(GUI.text(a.getName() + ": " + a.get()));
		}
		layout.addView(GUI.text("Skills"));
		for(Skill s : agent.getSkillSet().getSkills()) {
			layout.addView(GUI.text(s.getName() + ": " + s.get()));
		}
	}
	
	protected void addHeader(ViewGroup layout) {	
		if(agent==null) {
			showAgent(layout, Main.player.getPlayerAgent());
		} else {
			showAgent(layout, agent);
		}	
	}
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		commandList.add(new TreasureDisplay(agent, agent.getInventory(), "View Inventory"));
	}

}
