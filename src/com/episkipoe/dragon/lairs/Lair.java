package com.episkipoe.dragon.lairs;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.rooms.RoomSet;
import com.episkipoe.dragon.treasure.TreasureRoom;

public abstract class Lair extends CommandPage {
	protected Agent owner;
	protected LairList kingdom;
	protected Lair(Player player, Agent owner) {
		super(player);
		this.owner = owner;
	}

	/*
	 * Methods a lair may implement
	 */
	public List<Class<? extends Room>> getAllowedRooms() { return getCommonRooms(); }
	

	/*
	 *  Utility methods
	 */
	
	final public Agent getOwner() { return owner; }
	final public LairList getKingdom() { return kingdom; }
	final public void setKingdom(LairList kingdom) { this.kingdom = kingdom; }
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
	
	final protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		if(getRoomSet().numRooms() > 0) {
			commandList.addAll(getRoomSet().getRooms());
		}
		List<Command> buildCommands = getRoomBuildCommands();
		if(buildCommands != null) commandList.addAll(buildCommands); 
	}
	
	final public List<Class<? extends Room>> getCommonRooms() {
		List<Class<? extends Room>> roomList = new ArrayList<Class<? extends Room>>();
		roomList.add(GuardRoom.class);
		roomList.add(TreasureRoom.class);
		return roomList;
	}
	final public List<Command> getRoomBuildCommands() {
		List<Class<? extends Room>> roomList = getAllowedRooms();
		if(roomList == null) return null;
		List<Command> cmds = new ArrayList<Command>();
		for(Class<? extends Room> type : roomList) {
			if(getRoomSet().has(type)) continue;
			try {
				@SuppressWarnings("rawtypes")
				Class[] args = new Class[2];
				args[0] = Player.class;
				args[1] = Lair.class;
				Method m = type.getDeclaredMethod("getBuildCommand", args);
				Object o = m.invoke(null, player, this);
				Command cmd = (Command)o;
				if(cmd != null) cmds.add(cmd);
			} catch(Exception e) {
				System.out.println("Execption adding " + type.toString() + " : " + e.toString());
			}
		}
		return cmds;
	}
}

