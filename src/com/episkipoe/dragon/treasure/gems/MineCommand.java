package com.episkipoe.dragon.treasure.gems;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;

public class MineCommand extends Command  {
	private static final long serialVersionUID = 7933405921435543908L;
	Lair lair;
	public MineCommand(Lair lair) {
		this.lair = lair;
	}
	
	public void onClick(View v) {
	}
	
	@Override
	public String getCommandName() { return "Mine for gold"; }
}