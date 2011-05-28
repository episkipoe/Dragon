package com.episkipoe.dragon.events;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class EventQueue implements Serializable {
	private static final long serialVersionUID = 4018936763199025468L;

	Queue<Event> events=null;
	public EventQueue() {
		events = new LinkedList<Event> ();
	}
	public void add(Event event) {
		events.add(event);
		if(events.size()==1) EventScheduler.schedule(event);
	}
	public Event next() {
		if(events.isEmpty()) return null;
		Event next = events.remove();
		if(next != null) EventScheduler.schedule(next);
		return next;
	}
}
