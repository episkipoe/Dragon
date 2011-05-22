package com.episkipoe.dragon.treasure;

import android.app.AlertDialog;

import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.player.Player;

public class AddTreasureEvent extends Event {
	boolean notify=false;

	TreasureList treasureList;
	Treasure treasure;
	public AddTreasureEvent(Player player, TreasureList treasureList, Treasure treasure) {
		super(player);
		this.treasureList = treasureList;
		this.treasure = treasure;
	}
	
	public AddTreasureEvent(Player player, TreasureList treasureList, Treasure treasure, boolean notify) {
		super(player);
		this.treasureList = treasureList;
		this.treasure = treasure;
		if(notify) {
			run();
			showNotification();
		}
	}

	@Override
	public void run() {
		treasureList.add(treasure);
	}
	
	public void showNotification() {
		AlertDialog alertDialog;
		alertDialog = new AlertDialog.Builder(player.getActivity()).create();
		alertDialog.setTitle("Treasure Added");
		String message = treasure.qty + " " + treasure.getType() + " have been acquired";
		alertDialog.setMessage(message);
		alertDialog.show();
	}
}
