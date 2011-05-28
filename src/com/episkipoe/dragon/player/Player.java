package com.episkipoe.dragon.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.MotionEvent;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentDisplay;
import com.episkipoe.dragon.common.FileUtils;
import com.episkipoe.dragon.events.EventThread;
import com.episkipoe.dragon.events.GUIHandler;
import com.episkipoe.dragon.events.MaintenanceTimerTask;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.pages.PageManager;

public class Player implements Serializable {
	private static final long serialVersionUID = 5858314289857453333L;
	
	private transient Activity activity=null;
	public Activity getActivity() { return activity; }
	
	public Player(Activity activity) throws Exception {
		this.activity = activity;
	}
	
	static private final String PLAYER_FILE="player";
	public void save() throws Exception {
		FileUtils.writeToFile(FileUtils.getFile(PLAYER_FILE), this);
	}
	
	static public Player load(Activity activity) throws Exception {
		String fileName = PLAYER_FILE;
		if(!FileUtils.getFile(fileName).exists()) return null;
		
		Object player ;
		try {
			player = FileUtils.readFromFile(FileUtils.getFile(fileName));
			if(player==null) return null;
		} catch(Exception e) {
			System.out.println("could not load: " + e.getMessage());
			return null;
		}
		Player p = (Player) player;
		p.activity = activity;
		return p;
	}
	
	static public void loadGame(Activity activity) throws Exception {
    	Main.player = Player.load(activity);	
    	if(Main.player==null) { return; }
		Main.player.startGame();
	}
	
	static public void newGame(Activity activity) throws Exception {
		Main.player = new Player(activity);
		int nearByKingdoms = 10;
		PlayerUtils.initializeTestPlayer(Main.player, nearByKingdoms);		
		Main.player.startGame();
	}
	
	private transient MaintenanceTimerTask maintenanceTimer=null;
	public void startGame() {
		maintenanceTimer = new MaintenanceTimerTask(); 
		Main.player.showMainPage();
	}
	
	public void endGame() {
		if(maintenanceTimer != null) {
			maintenanceTimer.end();
		}
	}
	
	public void setMainTitle() {
		Main.player.getActivity().setTitle(Main.player.getPlayerAgent().getDescription());
	}
	
	public AgentDisplay getAgentDisplay() {
		return new AgentDisplay();
	}
	
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
		if(pageManager==null) { pageManager = new PageManager(this); }
		return pageManager; 
	}
	
	public void showMainPage() {
		MainPage main = new MainPage();
		getPageManager().setView(main.getPage());
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		getPageManager().onTouchEvent(event);
		return false;
	}

	private transient EventThread eventThread = null;
	public EventThread getEventThread() { 
		if(eventThread == null) {
			eventThread = new EventThread();
			eventThread.start();
		}
		return eventThread; 
	}
	private transient GUIHandler guiHandler;
	public GUIHandler guiHandler() { 
		if(guiHandler==null) { guiHandler = new GUIHandler(); }
		return guiHandler;
	}
	public void popupNotify(String text) {
		GUIHandler.popupNotify(guiHandler(), text);
	}
	public void refresh() {
		guiHandler().sendEmptyMessage(GUIHandler.REFRESH);
	}
}
