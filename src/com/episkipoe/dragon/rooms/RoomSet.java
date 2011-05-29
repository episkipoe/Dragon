package com.episkipoe.dragon.rooms;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoomSet implements Serializable {
	private static final long serialVersionUID = -2653361418458383728L;
	
	private Map<Class<? extends Room>,Room> rooms;
	private Map<Class<? extends Room>,Boolean> buildQueued;
	public RoomSet() {
		rooms = new HashMap<Class<? extends Room>,Room>();
		buildQueued = new HashMap<Class<? extends Room>,Boolean>();
	}
	
	public String getName() { return "View Rooms"; }
	
	public void add(Room r) { rooms.put(r.getClass(), r); }
	public Room get(Class<? extends Room> c) { return rooms.get(c); }
	public  boolean has(Class<? extends Room> c) { return rooms.containsKey(c); }
	public int numRooms() { return rooms.size(); }

	public Collection<Room> getRooms () { return rooms.values(); }

	public void queueBuild(Class<? extends Room> type) {
		buildQueued.put(type, true);
	}
	public boolean buildQueued(Class<? extends Room> type) {
		return (buildQueued.containsKey(type)); 
	}

}
