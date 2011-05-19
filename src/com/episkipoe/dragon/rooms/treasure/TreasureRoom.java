package com.episkipoe.dragon.rooms.treasure;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;

import android.view.View;

public class TreasureRoom extends Room {

	public TreasureRoom(Player player) {
		super(player);
		treasures = new ArrayList<Treasure>();
	}

	List<Treasure> treasures;
	
	public String getName() { return "Treasure Room"; }

	public View getActions() {
		return null;
	}

}
