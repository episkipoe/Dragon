package com.episkipoe.dragon.player;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.dragons.DragonAgent;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.pages.PageManager;

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
		mainActions.add(getLairList());	
	}
	
	public Activity getActivity() { return activity; }
	
	Agent playerAgent=null;
	public Agent getPlayerAgent() {
		if(playerAgent==null) {
			playerAgent = new DragonAgent();
			playerAgent.setRelationship(Relationship.PLAYER);
		}
		return playerAgent;
	}
	
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
	
	LairList neighboringKingdoms=null;
	public LairList getNeighboringKingdoms() { 
		if(neighboringKingdoms==null) neighboringKingdoms = new LairList(this);
		return neighboringKingdoms; 
	}
	
	PageManager pageManager=null; 
	public PageManager getPageManager() { 
		if(pageManager==null) pageManager = new PageManager(this);
		return pageManager; 
	}
	
	public void showMainPage() {
		getPageManager().setView(getActions());
	}
	public void setMainTitle() {
		activity.setTitle("Dragon");
	}
	public View getActions() {
		setMainTitle();
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
