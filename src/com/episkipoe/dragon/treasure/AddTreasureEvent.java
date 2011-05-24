package com.episkipoe.dragon.treasure;

import android.app.AlertDialog;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.events.Event;

public class AddTreasureEvent extends Event {
	boolean notify=false;

	TreasureList treasureList;
	Treasure treasure;
	public AddTreasureEvent(TreasureList treasureList, Treasure treasure) {
		this.treasureList = treasureList;
		this.treasure = treasure;
	}
	
	public AddTreasureEvent(TreasureList treasureList, Treasure treasure, boolean notify) {
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
		alertDialog = new AlertDialog.Builder(Main.player.getActivity()).create();
		alertDialog.setTitle("Treasure Added");
		String message = treasure.qty + " " + treasure.getType() + " have been acquired";
		alertDialog.setMessage(message);
		alertDialog.show();
	}
}
