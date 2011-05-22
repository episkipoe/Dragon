package com.episkipoe.dragon.rooms;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.episkipoe.dragon.player.Player;

public class RoomSet {
	Player player;
	public RoomSet(Player player) {
		this.player = player;
		rooms = new HashMap<Class<? extends Room>,Room>();
	}
	
	public String getName() { return "View Rooms"; }
	
	private Map<Class<? extends Room>,Room> rooms;
	public void add(Room r) { rooms.put(r.getClass(), r); }
	public Room get(Class<? extends Room> c) { return rooms.get(c); }
	public  boolean has(Class<? extends Room> c) { return rooms.containsKey(c); }
	public int numRooms() { return rooms.size(); }

	public Collection<Room> getRooms () { return rooms.values(); }
	
}
