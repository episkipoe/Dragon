package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.Lair;

public abstract class Room extends CommandPage {
	protected Lair lair;
	protected Room() {} 
	protected Room(Lair lair) {
		this.lair = lair;
		level=1;
	}
	
	public int level;
	public void hireAgent(Agent agent) { }
	abstract public Command getBuildCommand(Lair lair); 
	
	final public Lair getLair() { return lair; }
	private AgentList guards=null;
	final public AgentList getGuards() { 
		if(guards==null) guards = new AgentList();
		return guards;
	}
	
	
}

