package com.episkipoe.dragon.test.rooms;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.RoomList;
import com.episkipoe.dragon.rooms.treasure.TreasureRoom;

public class RoomTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public RoomTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testRoomList() {
		Player player = new Player();
		RoomList roomList = new RoomList(player);
		assertTrue(roomList.numRooms() == 0);
		roomList.add(new TreasureRoom(player));
		assertTrue(roomList.numRooms() == 1);
	}
}
