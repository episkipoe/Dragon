package com.episkipoe.dragon.lairs.forest;

import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.ProductionCommand;
import com.episkipoe.dragon.production.ProductionRoom;

public class ForestRoom extends ProductionRoom {
	private static final long serialVersionUID = 9043244252141545347L;

	@Override
	public String getCommandName() { return "Forest"; }
	
	@Override
	public List<ProductionCommand> getProductionCommands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command getBuildCommand(Lair lair) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postCreate(int level) {
		// TODO Auto-generated method stub

	}



}
