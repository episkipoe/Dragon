package com.episkipoe.dragon.production;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.RaidCommand;

public abstract class ProductionRoom extends Room {
	private static final long serialVersionUID = -8274655596305471194L;
	private ProductionList produces=null;
	public boolean productionInProgress;
	public ProductionRoom() { }
	public ProductionRoom(Lair lair) {
		super(lair);
		produces = new ProductionList();
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
			List<ProductionCommand> productionCommands = getProductionCommands();
			if(productionInProgress) {
				for(ProductionCommand c : productionCommands) c.setEnabled(false);
			}
			cmds.addAll(productionCommands);
			break;	
		case NEUTRAL: case ENEMY:
			cmds.add(new RaidCommand(lair, lair.getOwnerAndType()));
			break;
		}
		return cmds;
	}
	

}
