package com.episkipoe.dragon.player;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.rooms.treasure.TreasureBuilder;

public class Player {
	Activity activity=null;
	public Player(Activity activity) {
		this.activity = activity;
		PlayerUtils.initializePlayer(this);		
		loadMainActions();
	}
	public Player() {
		loadMainActions();
	}
	
	List<CommandPage> mainActions;
	void loadMainActions() {
		mainActions = new ArrayList<CommandPage> ();
		mainActions.add(getTreasureBuilder());
		mainActions.add(getLairList());	
	}
	
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

	PageManager pageManager=null; 
	public PageManager getPageManager() { 
		if(pageManager==null) pageManager = new PageManager(this);
		return pageManager; 
	}
	
	public void showMainPage() {
		getPageManager().setView(getActions());
	}
	
	public View getActions() {
		LinearLayout layout = new LinearLayout(activity);
		layout.setOrientation(LinearLayout.VERTICAL);
		for (CommandPage cmds : mainActions) {
			layout.addView(cmds.getButton()); 
		}
		return layout;
	}
	public boolean onTouchEvent(MotionEvent event) {
		getPageManager().onTouchEvent(event);
		return false;
	}



	
}
