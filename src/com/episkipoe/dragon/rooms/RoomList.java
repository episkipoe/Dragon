package com.episkipoe.dragon.rooms;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.episkipoe.dragon.player.Player;

public class RoomList {
	Player player;
	public RoomList(Player player) {
		this.player = player;
		rooms = new TreeMap<String,Room>();
	}
	
	public String getName() { return "View Rooms"; }
	
	private Map<String,Room> rooms;
	public void add(Room r) { rooms.put(r.getCommandName(), r); }
	public void setRoom(String type, Room r) { rooms.put(type,r); }
	public Room getRoom(String type) { return rooms.get(type); }
	public int numRooms() { return rooms.size(); }

	public Collection<Room> getRooms () { return rooms.values(); }
	
}
