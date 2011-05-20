package com.episkipoe.dragon.rooms;

import java.util.Map;
import java.util.TreeMap;

import android.view.View;
import android.widget.LinearLayout;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

public class RoomList extends CommandPage {
	public RoomList(Player player) {
		super(player);
		rooms = new TreeMap<String,Room>();
	}
	
	public String getName() { return "View Rooms"; }
	
	private Map<String,Room> rooms;
	public void add(Room r) { rooms.put(r.getName(), r); }
	public void setRoom(String type, Room r) { rooms.put(type,r); }
	public Room getRoom(String type) { return rooms.get(type); }
	public int numRooms() { return rooms.size(); }

	public View getActions() {
		LinearLayout layout = new LinearLayout(player.getActivity());

		for(Room r : rooms.values()) {
			layout.addView(r.getButton());
		}
		
		return layout;
	}
	
}
