package com.episkipoe.dragon.test.events;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.events.MaintenanceTimerTask;
import com.episkipoe.dragon.player.Player;

public class EventTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public EventTest() { 
		super("com.episkipoe.dragon", Main.class);
	}

	public void testMaintenance() throws Exception {
		@SuppressWarnings("unused")
		Player player = new Player(this.getActivity());
		MaintenanceTimerTask task = new MaintenanceTimerTask();
		task.run();
	}
}
