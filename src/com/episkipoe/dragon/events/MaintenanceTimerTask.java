package com.episkipoe.dragon.events;

import java.util.Timer;
import java.util.TimerTask;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.rooms.Room;

public class MaintenanceTimerTask extends TimerTask {
	Timer timer=null;
	public MaintenanceTimerTask () {
		EventScheduler.repeat(this, Main.player.getSettings().eventPeriod);
	}
	
	public void finalize() {
		end();
	}

	public void maintainRooms(LairList lairList) {
		for(Lair l: lairList.getLairs()) {
			for(Room r : l.getRoomSet().getRooms()) {
				r.scheduleEvents();
			}
		}
	}
	
	public void maintainLairs() {
		maintainRooms(Main.player.getLairList());
		for(LairList l : Main.player.getNeighboringKingdoms()) {
			maintainRooms(l);
		}
	}
	
	@Override
	public void run() {
		maintainLairs();
	}
	
	public void end() {
		if(timer!=null) timer.cancel();
	}

}
