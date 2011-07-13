package com.episkipoe.dragon.rooms;

import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.events.EventQueue;
import com.episkipoe.dragon.lairs.Lair;

public abstract class Room extends CommandPage {
	private static final long serialVersionUID = -7495858751162192872L;
	protected Lair lair;
	protected Room() {} 
	protected Room(Lair lair) {
		this.lair = lair;
	}

	/*
	 * Methods subclasses must/should implement 
	 */
	abstract public Command getBuildCommand(Lair lair); 
	abstract public void postCreate(int level);
	
	/**
	 * Schedule any events that the room should periodically fire (e.g. production by employees)
	 */
	public void scheduleEvents() { }
	public List<Command> getHireCommands() { return null; }

	/*
	 * Utility methods
	 */
	final public Lair getLair() { return lair; }
	final public void setLair(Lair lair) { this.lair = lair; }
	
	private int level=1;
	final public int getLevel() { return level; }
	final public void increaseLevel() { level++; }

	private AgentList employees=null;
	final public AgentList getEmployees() { 
		if(employees==null) employees = new AgentList();
		return employees;
	}
	final public void hireAgent(Agent agent) { 
		getEmployees().add(agent);
		agent.setLocation(this);
	}
	
	private AgentList guards=null;
	final public AgentList getGuards() { 
		if(guards==null) guards = new AgentList();
		return guards;
	}
	final public void hireGuard(Agent agent) { 
		getGuards().add(agent);
		agent.setLocation(this);
	}
	final public Command getAddGuardCommand() {
		//TODO  AddGuardCommand
		return null;
	}
	
	final public void addCommonRoomCommands() {
		switch(Agent.getRelationship(lair.getOwner())) {
		case PLAYER:
			//commandList.add(getAddGuardCommand());
			List<Command> hireCmds = getHireCommands();
			if(hireCmds != null) commandList.addAll(hireCmds);
		}
	}
	
	private EventQueue events=null;
	final public EventQueue getEvents() {
		if(events==null) events = new EventQueue();
		return events;
	}
	final public void addEvent(Event event) {
		getEvents().add(event);
	}
}

