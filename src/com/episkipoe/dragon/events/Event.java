package com.episkipoe.dragon.events;

import java.io.Serializable;

import com.episkipoe.dragon.agents.Agent;

/**
 *  After an event is run it should call postRun() in order to maintain the chain of events
 *
 */
public abstract class Event implements Runnable, Serializable {
	private static final long serialVersionUID = -8639679334914568595L;
	
	public Agent agent;
	public int delay;
	public Event(Agent agent, int delay) {
		this.agent = agent;
		this.delay = delay;
		agent.addEvent(this);
		if(agent.getEvents().size()==1) {
			EventScheduler.schedule(this);
		}
	}
	final public void postRun() { 
		agent.removeEvent(this); 
		if(agent.getEvents().size() > 0) {
			EventScheduler.schedule(agent.getEvents().get(0));
		}
	}
	public void run() { } 
}
