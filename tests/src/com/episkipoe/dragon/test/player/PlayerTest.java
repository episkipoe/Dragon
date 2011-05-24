package com.episkipoe.dragon.test.player;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.player.PlayerUtils;

public class PlayerTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public PlayerTest() { 
		super("com.episkipoe.dragon", Main.class);
	}

	public void testKingdomCreation() throws Exception {
		Player testAddPlayer = new Player();
		int nearByKingdoms=3;
		PlayerUtils.initializeTestPlayer(testAddPlayer, nearByKingdoms);
		assertTrue(testAddPlayer.getNeighboringKingdoms().size() == nearByKingdoms);
	}
	
	public void testPlayer() throws Exception {
		Player player = new Player(this.getActivity());
		assertTrue(player.getLairList().isMine());
	}
}