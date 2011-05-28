package com.episkipoe.dragon.events;

import java.util.Timer;

import com.episkipoe.dragon.Main;

public class EventScheduler {
	public static void schedule(Event event, int afterNSeconds) {
		EventQueue e = Main.player.getEventQueue();
		e.getHandler().postDelayed(event, (long) (afterNSeconds*1000));
	}
	
	public static Timer repeat(Event event, int everyNSeconds) {
		Timer timer = new Timer(true);
		long ms = (long) (everyNSeconds*1000);
		timer.schedule(event, ms, ms);
		return timer;
	}
}
