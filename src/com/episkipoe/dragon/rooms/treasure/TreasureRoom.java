package com.episkipoe.dragon.rooms.treasure;

import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.TextView;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;

public class TreasureRoom extends Room {

	public TreasureRoom(Player player) {
		super(player);
	}

	TreasureList treasures=null;
	public TreasureList getTreasureList() {
		if(treasures==null) treasures=new TreasureList(player);
		return treasures;
	}
	
	public String getName() { return "Treasure Room"; }
	
	TreasureBuilder treasureBuilder=null;
	public TreasureBuilder getTreasureBuilder() {
		if(treasureBuilder==null) treasureBuilder = new TreasureBuilder(player, getTreasureList());
		return treasureBuilder;
	}
	
	protected void addHeader(ViewGroup layout) { 
		TextView lbl = new TextView(player.getActivity());
		lbl.setText("Total Value: " + getTreasureList().totalValue());
	}	
	
	protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		commandList.add(getTreasureBuilder());
		
		TreasureDisplay display = new TreasureDisplay(player, getTreasureList());
		commandList.add(display);
	}

}
