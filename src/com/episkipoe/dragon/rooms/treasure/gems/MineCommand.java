package com.episkipoe.dragon.rooms.treasure.gems;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;

public class MineCommand extends Command  {
	Lair lair;
	public MineCommand(Player player, Lair lair) {
		super(player);
		this.lair = lair;
	}
	
	public void onClick(View v) {
	}
	
	@Override
	public String getCommandName() { return "Mine for gold"; }
}