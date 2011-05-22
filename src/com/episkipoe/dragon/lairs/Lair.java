package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.RoomSet;
import com.episkipoe.dragon.treasure.Cost;

public abstract class Lair extends CommandPage {
	protected Agent owner;
	protected Lair(Player player, Agent owner) {
		super(player);
		this.owner = owner;
	}

	/*
	 * Methods a lair may implement
	 */
	public List<Command> getRoomBuildCommands() { return null; }
	

	/*
	 *  Utility methods
	 */
	
	final public Agent getOwner() { return owner; }
	final public String getOwnerAndType() { return owner.getName() + "'s" + getCommandName(); }
	final public boolean isMine() { return (owner.getRelationship() == Relationship.PLAYER); }
	
	private LairProperties properties=null;
	final public LairProperties getProperties() {
		if(properties==null) properties = new LairProperties();
		return properties;
	}
	
	private RoomSet rooms=null;
	final public RoomSet getRoomSet() { 
		if(rooms==null) rooms = new RoomSet(player);
		return rooms;
	}
	
	private AgentList denizens=null;
	final public AgentList getDenizenList() { 
		if(denizens==null) denizens = new AgentList(player);
		return denizens;
	}	
	
	final public boolean subtractCost(Cost cost, boolean notify) {
		return true;
	}
	
	final protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		if(getRoomSet().numRooms() > 0) {
			commandList.addAll(getRoomSet().getRooms());
		}
		List<Command> buildCommands = getRoomBuildCommands();
		if(buildCommands != null) commandList.addAll(buildCommands); 
	}
	
}

