package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

public class LairList extends CommandPage {
	public LairList(Player player) {
		super(player);
	}
	
	public String getCommandName() { return "Manage Lairs"; }
	
	List<Lair> lairs = null;
	public void addLair(Lair l) { getLairs().add(l); }
	public List<Lair> getLairs() { 
		if(lairs==null) lairs = new ArrayList<Lair>();
		return lairs; 
	}
	
	LairBuilder lairBuilder=null;
	private LairBuilder getLairBuilder() {
		if(lairBuilder==null) lairBuilder = new LairBuilder(player);
		return lairBuilder;
	}

	protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		if(lairs==null) return;
		for(Lair l : lairs) commandList.add(l);
		commandList.add(getLairBuilder());
	}
	
}