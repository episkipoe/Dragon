package com.episkipoe.dragon.lairs;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.player.Player;

public class LairBuilder extends Command {
	public LairBuilder(Player player) {
		super(player);
	}

	@Override
	public String getCommandName() { return "Add Lair"; }
	
	public void onClick(View v) {
		//TODO add lair
	}



}
