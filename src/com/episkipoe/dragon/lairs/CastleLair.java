package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.Collection;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.RaidCommand;

public class CastleLair extends Lair {
	public CastleLair(Player player, Agent owner) {
		super(player, owner);
	}

	@Override
	public String getCommandName() { return "Castle"; }
	
	public Collection<Command> treasureRoom() { 
		if(owner==null) return null;
		Collection<Command> cmds = new ArrayList<Command>();
		switch(owner.getRelationship()) {
		case PLAYER:
			//cmds.add(new TaxCommand(player, this));
			break;
		case ENEMY:
			cmds.add(new RaidCommand(player, this, getOwnerAndType()));
			break;
		}
		return cmds;
	}

}
