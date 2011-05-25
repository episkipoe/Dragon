package com.episkipoe.dragon.treasure;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;

public class RaidCommand extends Command {
	private static final long serialVersionUID = 2976420337615102703L;
	Lair lair;
	String target;
	public RaidCommand (Lair lair, String target) {
		this.lair = lair;
		this.target = target;
	}
	
	public void onClick(View v) {
		//TODO transfer resources / prisoners on raid
	}

	@Override
	public String getCommandName() { return "Raid " + target; }

}
