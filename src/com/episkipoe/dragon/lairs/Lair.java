package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.Collection;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.RoomList;

public abstract class Lair extends CommandPage {
	protected Agent owner;
	protected Lair(Player player, Agent owner) {
		super(player);
		this.owner = owner;
	}
	
	public String getOwnerAndType() { return owner.getName() + "'s" + getCommandName(); }
	
	private LairProperties properties=null;
	public LairProperties getProperties() {
		if(properties==null) properties = new LairProperties();
		return properties;
	}
	
	RoomList rooms=null;
	public RoomList getRoomList() { 
		if(rooms==null) rooms = new RoomList(player);
		return rooms;
	}
	

	
	// Actions that having a lair of this type enables
	public Collection<Command> treasureRoom() { return null; }
	public Collection<Command> prisonRoom() { return null; }
	
	protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		if(rooms==null) return;
		commandList.addAll(getRoomList().getRooms());
	}

}

