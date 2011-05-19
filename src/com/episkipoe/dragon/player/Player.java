package com.episkipoe.dragon.player;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.MountainLair;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.rooms.treasure.TreasureBuilder;
import com.episkipoe.dragon.rooms.treasure.TreasureRoom;

public class Player {
	public Player(Activity activity) {
		this.activity = activity;
		
		//PlayerUtils.initializePlayer(this);		
		Lair firstLair = new MountainLair(this);
		Room firstRoom = new TreasureRoom(this);
		firstLair.getRoomList().add(firstRoom);
		getLairList().addLair(firstLair);	
		
		mainActions = new ArrayList<CommandPage> ();
		mainActions.add(getTreasureBuilder());
		mainActions.add(getLairList());
	}
	
	List<CommandPage> mainActions;
	
	Activity activity;
	public Activity getActivity() { return activity; }
	
	PlayerProperties properties=null;
	public PlayerProperties getProperties() {
		if(properties==null) properties = new PlayerProperties();
		return properties;
	}
	
	LairList lairs=null;
	public LairList getLairList() { 
		if(lairs==null) lairs = new LairList(this);
		return lairs; 
	}
	
	TreasureBuilder treasureBuilder=null;
	public TreasureBuilder getTreasureBuilder() {
		if(treasureBuilder==null) treasureBuilder = new TreasureBuilder(this);
		return treasureBuilder;
	}

	ViewFlipper flipper; 
	public ViewFlipper getFlipper() { return flipper; }
	
	public void showMainPage() {
		flipper = new ViewFlipper(activity);
		flipper.addView(getActions());
		activity.setContentView(flipper);
	}
	
	public View getActions() {
		LinearLayout layout = new LinearLayout(activity);
		layout.setOrientation(LinearLayout.VERTICAL);
		for (CommandPage cmds : mainActions) {
			layout.addView(cmds.getButton()); 
		}
		return layout;
	}
	

	
}
