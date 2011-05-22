package com.episkipoe.dragon.events;

import java.util.Timer;

public class EventScheduler {
	public static void schedule(Event event, int afterNSeconds) {
		Timer timer = new Timer(true);
		timer.schedule(event, (long) (afterNSeconds*1000));
	}
	
	public static Timer repeat(Event event, int everyNSeconds) {
		Timer timer = new Timer(true);
		long ms = (long) (everyNSeconds*1000);
		timer.schedule(event, ms, ms);
		return timer;
	}
}
