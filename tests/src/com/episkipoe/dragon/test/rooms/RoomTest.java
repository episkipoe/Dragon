package com.episkipoe.dragon.test.rooms;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.MountainLair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.rooms.RoomSet;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class RoomTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public RoomTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testRoomList() {
		Player player = new Player();
		RoomSet roomList = new RoomSet(player);
		assertTrue(roomList.numRooms() == 0);
		Lair firstLair = new MountainLair(player, player.getPlayerAgent());
		Room firstRoom = new TreasureRoom(player, firstLair);
		assertFalse(roomList.has(TreasureRoom.class));
		roomList.add(firstRoom);
		assertTrue(roomList.numRooms() == 1);
		assertTrue(roomList.has(TreasureRoom.class));
		assertFalse(roomList.has(BreweryRoom.class));
	}
}
