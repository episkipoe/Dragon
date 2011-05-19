package com.episkipoe.dragon.rooms.prison;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;

import android.view.View;

class PrisonRoom extends Room {

	protected PrisonRoom(Player player) {
		super(player);
		prisoners = new ArrayList<Prisoner>();
	}

	List<Prisoner> prisoners;
	public void add(Prisoner p) { prisoners.add(p); }
	
	public String getName() { return "Prison"; }

	public View getActions() {
		return null;
	}

}
