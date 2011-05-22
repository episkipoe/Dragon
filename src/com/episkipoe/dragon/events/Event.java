package com.episkipoe.dragon.events;

import java.util.TimerTask;

import com.episkipoe.dragon.player.Player;

public abstract class Event extends TimerTask {
	protected Player player;
	public Event(Player player) {
		this.player = player;
	}


}
