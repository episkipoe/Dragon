package com.episkipoe.dragon.agents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AgentList {
	public AgentList() {
		agents = new ArrayList<Agent>();
	}
	
	public String getName() { return "View Agents"; }
	
	private List<Agent> agents;
	public void add(Agent a) { agents.add(a); }
	public int numAgents() { return agents.size(); }

	public Collection<Agent> getAgents () { return agents; }
	
}
