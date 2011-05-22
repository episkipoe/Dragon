package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;

public abstract class Room extends CommandPage {
	protected Lair lair;
	protected Room(Player player, Lair lair) {
		super(player);
		this.lair = lair;
		level=1;
	}
	
	public Lair getLair() { return lair; }
	
	public int level;
	private AgentList guards=null;
	public AgentList getGuards() { 
		if(guards==null) guards = new AgentList(player);
		return guards;
	}
	
	public void hireAgent(Agent agent) { }
}

