package com.episkipoe.dragon.agents;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.episkipoe.dragon.player.Player;

public class AgentList {
	Player player;
	public AgentList(Player player) {
		this.player = player;
		agents = new TreeMap<String,Agent>();
	}
	
	public String getName() { return "View Agents"; }
	
	private Map<String,Agent> agents;
	public void add(Agent a) { agents.put(a.getName(), a); }
	public void setAgent(String type, Agent a) { agents.put(type,a); }
	public Agent getAgent(String type) { return agents.get(type); }
	public int numAgents() { return agents.size(); }

	public Collection<Agent> getAgents () { return agents.values(); }
	
}
