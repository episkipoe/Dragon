package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

public class LairList extends CommandPage {
	Agent owner;
	public LairList(Player player, Agent owner) {
		super(player);
		this.owner = owner;
	}
	
	public String getCommandName() { 
		if(owner.getRelationship()==Relationship.PLAYER) {
			return "Visit your lairs"; 
		} else {
			return "Visit " + owner.getName(); 
		}
	}
	public boolean isMine() { return (owner.getRelationship() == Relationship.PLAYER); }
	
	List<Lair> lairs = null;
	public void addLair(Lair l) { 
		l.setKingdom(this);
		getLairs().add(l); 
	}
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
		if(isMine()) commandList.add(getLairBuilder());
	}
	
}