package com.episkipoe.dragon.lairs;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.events.EventScheduler;

public class BuildLairCommand extends Command {
	private static final long serialVersionUID = -2659403363456605251L;
	private LairList kingdom;
	private Lair lair;
	private Cost cost;
	public BuildLairCommand(LairList kingdom, Lair lair, Cost cost) {
		this.kingdom = kingdom;
		this.lair = lair;
		this.cost = cost;
	}

	public void onClick(View v) {
		BuildLairEvent event = new BuildLairEvent(kingdom, lair, cost, true); 
		if(v==null) {
			event.run();
		} else {
			EventScheduler.schedule(event, cost.getWaitTime());
		}
		Main.player.popupNotify("Build in progress");
		Main.player.getPageManager().refresh();
	}

	@Override
	public String getCommandName() { return "Build " + lair.getCommandName() ; }
	public String getDescription() { 
		return cost.toString(); 
	}

}
