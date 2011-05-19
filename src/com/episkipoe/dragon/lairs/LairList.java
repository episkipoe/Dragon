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
	
	public String getName() { return "Manage Lairs"; }
	
	List<Lair> lairs;
	public void addLair(Lair l) { lairs.add(l); }
	public List<Lair> getLairs() { return lairs; }

	protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		if(lairs==null) return;
		System.out.println(lairs.size() + " lairs");
		for(Lair l : lairs) commandList.add(l);
	}
	
}