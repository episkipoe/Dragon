package com.episkipoe.dragon.test.rooms;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.MountainLair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;
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
		Lair firstLair = new MountainLair(player, player.getPlayerAgent());
		Room firstRoom = new TreasureRoom(player, firstLair);
		roomList.add(firstRoom);
		assertTrue(roomList.numRooms() == 1);
	}
}
