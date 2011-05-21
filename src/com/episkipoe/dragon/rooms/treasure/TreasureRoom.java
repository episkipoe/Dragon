package com.episkipoe.dragon.rooms.treasure;

import java.util.ArrayList;
import java.util.Collection;

import android.view.ViewGroup;
import android.widget.TextView;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;

public class TreasureRoom extends Room {

	public TreasureRoom(Player player, Lair lair) {
		super(player, lair);
	}

	TreasureList treasures=null;
	public TreasureList getTreasureList() {
		if(treasures==null) treasures=new TreasureList(player);
		return treasures;
	}
	
	public String getCommandName() { return "Treasure Room"; }
	
	protected void addHeader(ViewGroup layout) { 
		TextView lbl = new TextView(player.getActivity());
		lbl.setText("Total Value: " + getTreasureList().totalValue());
	}	
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		Collection<Command> lairOptions = lair.treasureRoom();
		if(lairOptions != null) commandList.addAll(lairOptions);
		TreasureDisplay display = new TreasureDisplay(player, getTreasureList());
		commandList.add(display);
	}

}
