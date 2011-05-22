package com.episkipoe.dragon.treasure;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;

public class RaidCommand extends Command {
	Lair lair;
	String target;
	public RaidCommand (Player player, Lair lair, String target) {
		super(player);
		this.lair = lair;
		this.target = target;
	}
	
	public void onClick(View v) {
		
	}

	@Override
	public String getCommandName() { return "Raid " + target; }

}
