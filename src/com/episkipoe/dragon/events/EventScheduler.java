package com.episkipoe.dragon.events;

import java.util.Timer;
import java.util.TimerTask;

import com.episkipoe.dragon.Main;

public class EventScheduler {
	public static void schedule(Event event) {
		EventThread e = Main.player.getEventThread();
		e.getHandler().postDelayed(event, (long) (event.delay*1000));
	}
	
	public static Timer repeat(TimerTask event, int everyNSeconds) {
		Timer timer = new Timer(true);
		long ms = (long) (everyNSeconds*1000);
		timer.schedule(event, ms, ms);
		return timer;
	}
}
