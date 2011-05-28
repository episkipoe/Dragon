package com.episkipoe.dragon.agents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.rooms.Room;

public class AgentList extends CommandPage {
	private static final long serialVersionUID = 6424021480518023824L;
	
	String commandName = "View Agents";
	public AgentList() {
		agents = new ArrayList<Agent>();
	}
	public AgentList(String commandName) {
		agents = new ArrayList<Agent>();
		this.commandName = commandName;
	}
	
	private List<Agent> agents;
	public void add(Agent a) { agents.add(a); }
	public int numAgents() { return agents.size(); }

	public Collection<Agent> getAgents () { return agents; }
	public Collection<Agent> getAvailable (Room room) { 
		List<Agent> available = new ArrayList<Agent>();
		for(Agent a : getAgents()) {
			if(a.getLocation().equals(room)) {
				available.add(a);
			}
		}
		return available; 
	}

	@Override
	public String getCommandName() {  return commandName; }
	
}
