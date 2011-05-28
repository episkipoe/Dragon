package com.episkipoe.dragon.events;

import java.io.Serializable;

/**
 *  After an event is run it should call postRun() in order to maintain the chain of events
 *
 */
public abstract class Event implements Runnable, Serializable {
	private static final long serialVersionUID = -8639679334914568595L;

	public EventQueue queue;
	public int delay;
	public Event(EventQueue queue, int delay) {
		this.queue = queue;
		this.delay = delay;
		queue.add(this);
	}
	final public void postRun() { 
		queue.next();
	}
	public void run() { } 
}
