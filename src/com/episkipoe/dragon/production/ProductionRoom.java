package com.episkipoe.dragon.production;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.RaidCommand;

public abstract class ProductionRoom extends Room {
	ProductionList produces=null;
	public ProductionRoom(Player player, Lair lair) {
		super(player, lair);
		produces = new ProductionList(player);
	}
	
	final public ProductionList getProductionList() { return produces; }

	abstract public List<ProductionCommand> getProductionCommands(); 
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		commandList.addAll(getProductionRoomCommands());
	}
	
	final public List<Command> getProductionRoomCommands() {
		List<Command> cmds = new ArrayList<Command>();
		switch(lair.getOwner().getRelationship()) {
		case PLAYER:
			cmds.addAll(getProductionCommands());
			break;	
		case NEUTRAL: case ENEMY:
			cmds.add(new RaidCommand(player, lair, lair.getOwnerAndType()));
			break;
		}
		return cmds;
	}
	

}
