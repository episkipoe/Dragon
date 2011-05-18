package com.episkipoe.dragon.player;

import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.MountainLair;

class PlayerUtils {

	static void initializePlayer(Player player) {
		Lair firstLair = new MountainLair();
		player.getLairList().addLair(firstLair);
	}
}
