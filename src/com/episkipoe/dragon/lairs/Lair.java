package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.rooms.RoomSet;
import com.episkipoe.dragon.treasure.TreasureRoom;

public abstract class Lair extends CommandPage {
	private static final long serialVersionUID = -323992456148996830L;
	public Lair() {}  //TODO:  test lair with no owner
	public Lair(Agent owner) {
		this.owner = owner;
	}

	/*
	 * Methods a lair must implement
	 */
	abstract public Command getBuildCommand(LairList kingdom) ;
	abstract public void postCreate(int level) ;
	
	/*
	 * Methods a lair may implement
	 */
	public List<Class<? extends Room>> getAllowedRooms() { return getCommonRooms(); }
	public boolean createOwner() { return false; }
	public List<Class<? extends Lair>> getSubLairs() { return null; }
	public String getDescription() { 
		return getRoomSet().numRooms() + " buildings";
	}


	/*
	 *  Utility methods
	 */
	
	private Agent owner;
	final public Agent getOwner() { return owner; }
	final public void setOwner(Agent owner) { this.owner = owner; }
	private LairList kingdom;
	final public LairList getKingdom() { return kingdom; }
	final public void setKingdom(LairList kingdom) { this.kingdom = kingdom; }
	final public String getOwnerAndType() { return owner.getName() + "'s" + getCommandName(); }
	final public boolean isMine() { return (Agent.getRelationship(owner) == Relationship.PLAYER); }
	
	private LairProperties properties=null;
	final public LairProperties getProperties() {
		if(properties==null) properties = new LairProperties();
		return properties;
	}
	
	private RoomSet rooms=null;
	final public RoomSet getRoomSet() { 
		if(rooms==null) rooms = new RoomSet();
		return rooms;
	}
	
	private AgentList denizens=null;
	final public AgentList getDenizenList() { 
		if(denizens==null) denizens = new AgentList();
		return denizens;
	}	
	
	final protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		if(getRoomSet().numRooms() > 0) {
			commandList.addAll(getRoomSet().getRooms());
		}
		if(isMine()) {
			List<Command> buildCommands = getRoomBuildCommands();
			if(buildCommands != null) commandList.addAll(buildCommands); 
		}
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
				Room r = type.newInstance();
				Command cmd = r.getBuildCommand(this);
				if(cmd==null) continue;
				if(rooms.buildQueued(type)) cmd.setEnabled(false);
				cmds.add(cmd);
			} catch(Exception e) {
				System.out.println("Execption adding " + type.toString() + " : " + e.toString());
			}
		}
		return cmds;
	}
	
	public void addRoomList(List<Class<? extends Room>> roomsToBuild, int level) {
		for(Class<? extends Room> type: roomsToBuild) {
			try {
				Room newRoom = type.newInstance();
				newRoom.setLair(this);
				newRoom.postCreate(level);
				getRoomSet().add(newRoom);	
			} catch (Exception e) {
				System.out.println("Problem adding room: " + e.getMessage());
			} 
		}
	}

}

