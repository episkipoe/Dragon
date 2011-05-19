package com.episkipoe.dragon.player;

import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.MountainLair;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.rooms.treasure.TreasureRoom;

public class PlayerUtils {

	public static void initializePlayer(Player player) {
		Lair firstLair = new MountainLair(player);
		Room firstRoom = new TreasureRoom(player);
		firstLair.getRoomList().add(firstRoom);
		player.getLairList().addLair(firstLair);
	}
}
