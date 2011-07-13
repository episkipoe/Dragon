package com.episkipoe.dragon.treasure;

import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.TextView;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.gems.GoldTreasure;

public class TreasureRoom extends Room {
	private static final long serialVersionUID = 4876002642363063730L;
	
	public TreasureRoom() { }
	public TreasureRoom(Lair lair) {
		super(lair);
	}

	TreasureList treasures=null;
	public TreasureList getTreasureList() {
		if(treasures==null) treasures=new TreasureList();
		return treasures;
	}
	
	public String getCommandName() { return "Store Room"; }
	
	protected void addHeader(ViewGroup layout) { 
		TextView lbl = new TextView(Main.player.getActivity());
		lbl.setText("Total Value: " + getTreasureList().totalValue(Main.player.getPlayerAgent()));
	}	
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		commandList.add(new TreasureDisplay(Main.player.getPlayerAgent(), getTreasureList()));
		switch(Agent.getRelationship(lair.getOwner())) {
		case NEUTRAL: case ENEMY:
			commandList.add(new RaidCommand(lair, lair.getOwnerAndType()));
			break;
		}
	}
	
	public Command getBuildCommand(Lair lair) {
		TreasureRoom room = new TreasureRoom(lair);
		TreasureList tl = new TreasureList();
		tl.add(new IronTreasure());
		Cost cost = new Cost(tl, 4);
		return new BuildRoomCommand(room, cost);
	}
	
	public void postCreate(int level) {
		//TODO  add more treasures based on level
		getTreasureList().add(new GoldTreasure(level*10));
	}
}
