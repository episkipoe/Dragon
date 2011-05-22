package com.episkipoe.dragon.rooms.food;

import java.util.ArrayList;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.RaidCommand;
import com.episkipoe.dragon.treasure.TreasureList;

public class BreweryRoom extends Room {

	public BreweryRoom(Player player, Lair lair) {
		super(player, lair);
	}
	
	TreasureList brews;

	private class BrewCommand extends Command {
		public BrewCommand(Player player) {
			super(player);
		}

		public void onClick(View v) {
			
		}

		@Override
		public String getCommandName() { return "Brew Ale (requires 1 grain)"; }
	
	}
	
	@Override
	public String getCommandName() { return "Brewery"; }
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		switch(lair.getOwner().getRelationship()) {
		case PLAYER:
			commandList.add(new BrewCommand(player));
			break;
		case NEUTRAL: case ENEMY:
			commandList.add(new RaidCommand(player, lair, lair.getOwnerAndType()));
			break;
		}
	}
}
