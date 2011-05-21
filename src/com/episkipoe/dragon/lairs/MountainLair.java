package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.Collection;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.treasure.RaidCommand;
import com.episkipoe.dragon.rooms.treasure.gems.MineCommand;

public class MountainLair extends Lair {
	public MountainLair(Player player, Agent owner) {
		super(player, owner);
	}

	public String getCommandName() { return "Mountain Lair"; }
	

	public Collection<Command> treasureRoom() { 
		if(owner==null) return null;
		Collection<Command> cmds = new ArrayList<Command>();
		switch(owner.getRelationship()) {
		case PLAYER:
			cmds.add(new MineCommand(player, this));
			break;
		case ENEMY:
			cmds.add(new RaidCommand(player, this, getOwnerAndType()));
			break;
		}
		return cmds;
	}
}
