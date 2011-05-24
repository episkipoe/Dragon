package com.episkipoe.dragon.test.lairs;

import java.util.List;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.mountain.MountainLair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.MineRoom;

public class LairTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public LairTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testLairList() throws Exception {
		Player player = new Player(this.getActivity());
		Agent playerAgent = player.getPlayerAgent();
		LairList lairList = new LairList(playerAgent);
		assertTrue(lairList.getLairs().size() == 0);
		Lair lair = new MountainLair(playerAgent);
		lairList.addLair(lair);
		assertTrue(lairList.getLairs().size() == 1);
		MineRoom m = new MineRoom();
		Command c = m.getBuildCommand(lair);
		assertTrue(c!=null);
		List<Command> cmdList = lair.getRoomBuildCommands();
		assertTrue(cmdList.size() > 0);
	}
}
