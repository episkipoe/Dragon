package com.episkipoe.dragon.treasure.gems;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.events.EventScheduler;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.treasure.AddTreasureEvent;
import com.episkipoe.dragon.treasure.Treasure;
import com.episkipoe.dragon.treasure.TreasureList;

public class MineCommand extends Command  {
	private static final long serialVersionUID = 7933405921435543908L;
	Lair lair;
	Treasure treasure;
	public MineCommand(Lair lair, Treasure treasure) {
		this.lair = lair;
		this.treasure = treasure;
	}
	
	public void onClick(View v) {
		TreasureList store = CommerceUtils.getNearestStore(lair);
		AddTreasureEvent event = new AddTreasureEvent(store, treasure);
		EventScheduler.schedule(event, 4);
	}
	
	@Override
	public String getCommandName() { return "Mine for " + treasure.getType(); }
}