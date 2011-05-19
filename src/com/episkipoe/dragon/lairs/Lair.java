package com.episkipoe.dragon.lairs;

import android.content.Context;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.RoomList;

public abstract class Lair extends CommandPage {

	protected Lair(Player player) {
		super(player);
		
	}

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
	public void acquireWealth(Context c) { }
	public void wreakHavoc(Context c) { }


}

