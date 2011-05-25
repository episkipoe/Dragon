package com.episkipoe.dragon.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentDisplay;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.common.FileUtils;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.pages.PageManager;

public class Player implements Serializable {
	private static final long serialVersionUID = 5858314289857453333L;
	
	public transient Activity activity=null;
	public Player(Activity activity) throws Exception {
		this.activity = activity;
		int nearByKingdoms = 10;
		PlayerUtils.initializeTestPlayer(this, nearByKingdoms);		
		loadMainActions();
	}
	public Player() {
		loadMainActions();
	}
	
	public void save() throws Exception {
		FileUtils.writeToFile(FileUtils.getFile("player_agent"), this);
	}
	
	static public Player load(Activity a) throws Exception {
		Object player ;
		try {
			player = FileUtils.readFromFile(FileUtils.getFile("player_agent"));
			if(player==null) return null;
		} catch(Exception e) {
			System.out.println("could not load: " + e.getMessage());
			return null;
		}
		Player p = (Player) player;
		p.activity = a;
		return p;
	}
	
	private class ListNeighbors extends CommandPage {
		private static final long serialVersionUID = -916989669844708976L;
		
		protected void prepareCommands() {
			commandList =new ArrayList<Command>();
			List<LairList> kingdoms = getNeighboringKingdoms();
			if(kingdoms==null) return;
			for(LairList ll : kingdoms) {
				commandList.add(ll);
			}
		}
		@Override
		public String getCommandName() { return "Visit another realm"; }
	}
	
	private transient List<CommandPage> mainActions;
	void loadMainActions() {
		mainActions = new ArrayList<CommandPage> ();
		mainActions.add(getLairList());	
		mainActions.add(new ListNeighbors());
		mainActions.add(new AgentDisplay(getPlayerAgent()));
	}
	
	public Activity getActivity() { return activity; }
	
	private Agent playerAgent=null;
	public Agent getPlayerAgent() {
		if(playerAgent==null) playerAgent = PlayerUtils.getPlayerAgent(this);
		return playerAgent;
	}
	
	private PlayerProperties properties=null;
	public PlayerProperties getProperties() {
		if(properties==null) properties = new PlayerProperties();
		return properties;
	}
	
	private PlayerSettings settings=null;
	public PlayerSettings getSettings() {
		if(settings==null) settings = new PlayerSettings();
		return settings;
	}
	
	private LairList lairs=null;
	public LairList getLairList() { 
		if(lairs==null) lairs = new LairList(playerAgent);
		return lairs; 
	}
	
	private List<LairList> neighboringKingdoms=null;
	public List<LairList> getNeighboringKingdoms() { 
		if(neighboringKingdoms==null) neighboringKingdoms = new ArrayList<LairList>();
		return neighboringKingdoms; 
	}
	
	private transient PageManager pageManager=null; 
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

	private transient TextView characterLabel=null;
	public void setCharacterLabel() {
		if(characterLabel == null) return ;
		characterLabel.setText(getPlayerAgent().getDescription());
		System.out.println("set lbl " + getPlayerAgent().getLevel());
	}
	
	public View getActions() {
		setMainTitle();
		LinearLayout layout = new LinearLayout(activity);
		layout.setOrientation(LinearLayout.VERTICAL);
		characterLabel = new TextView(activity);
		layout.addView(characterLabel);
		setCharacterLabel();
		for (CommandPage cmds : mainActions) {
			cmds.addToLayout(layout);
		}
		return layout;
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		getPageManager().onTouchEvent(event);
		return false;
	}

	public void onRestoreInstance(Bundle savedInstanceState) {
		
	}

	public void popupNotify(String text) {
		Toast toast = Toast.makeText(getActivity(), text, getSettings().toastDuration);	
		toast.show();
	}

	
}
