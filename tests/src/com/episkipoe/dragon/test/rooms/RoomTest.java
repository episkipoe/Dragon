package com.episkipoe.dragon.test.rooms;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.dungeon.DungeonRoom;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.mountain.MountainLair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.production.food.ForestRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.rooms.RoomSet;
import com.episkipoe.dragon.treasure.MineRoom;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class RoomTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public RoomTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testRoomList() throws Exception {
		Player player = new Player(this.getActivity());
		RoomSet roomList = new RoomSet();
		assertTrue(roomList.numRooms() == 0);
		Lair firstLair = new MountainLair(player.getPlayerAgent());
		List<Class<? extends Room>> roomsToAdd = new ArrayList<Class<? extends Room>>();
		roomsToAdd.add(GuardRoom.class);
		roomsToAdd.add(DungeonRoom.class);
		roomsToAdd.add(BreweryRoom.class);
		roomsToAdd.add(FarmRoom.class);
		roomsToAdd.add(ForestRoom.class);
		roomsToAdd.add(MineRoom.class);
		roomsToAdd.add(TreasureRoom.class);

		int numRooms=1;
		for(Class<? extends Room> type : roomsToAdd) {
			assertFalse(roomList.has(type));
			Room room = type.newInstance();
			room.setLair(firstLair);
			room.postCreate(1);
			roomList.add(room);
			assertTrue(roomList.numRooms() == numRooms);
			numRooms++;
			assertTrue(roomList.has(type));
		}
	}
}
