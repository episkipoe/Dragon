package com.episkipoe.dragon.test.lairs;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.MountainLair;
import com.episkipoe.dragon.player.Player;

public class LairTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public LairTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testLairList() {
		Player player = new Player();
		LairList lairList = new LairList(player);
		assertTrue(lairList.getLairs().size() == 0);
		lairList.addLair(new MountainLair(player));
		assertTrue(lairList.getLairs().size() == 1);
	}
}
