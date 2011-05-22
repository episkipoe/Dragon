package com.episkipoe.dragon.test.player;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.player.PlayerUtils;

public class PlayerTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public PlayerTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testPlayer() {
		Player player = new Player(this.getActivity());
		PlayerUtils.initializePlayer(player, 2);
		
		assertTrue(player.getLairList().isMine());
	}
}