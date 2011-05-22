package com.episkipoe.dragon.test.lairs;

import java.util.List;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.MountainLair;
import com.episkipoe.dragon.player.Player;

public class LairTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public LairTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testLairList() {
		Player player = new Player(this.getActivity());
		Agent playerAgent = player.getPlayerAgent();
		LairList lairList = new LairList(player, playerAgent);
		assertTrue(lairList.getLairs().size() == 0);
		Lair lair = new MountainLair(player, playerAgent);
		lairList.addLair(lair);
		assertTrue(lairList.getLairs().size() == 1);
		List<Command> cmdList = lair.getRoomBuildCommands();
		assertTrue(cmdList.size() > 0);
	}
}
