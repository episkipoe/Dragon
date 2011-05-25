package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionCommand;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.rooms.BuildRoomCommand;

public class FarmRoom extends ProductionRoom {
	private static final long serialVersionUID = -2818358797223917564L;
	
	List<ProductionCommand> products;
	public FarmRoom() { }
	public FarmRoom(Lair lair) {
		super(lair);
		products = new ArrayList<ProductionCommand>();
		
		Product grain = getProductionList().addProduct(new GrainTreasure(2));
		grain.getCost().increaseWaitTime(5);
		products.add(new FarmGrainCommand(this, grain));
	}

	@Override
	public String getCommandName() { return "Farm"; }

	private class FarmGrainCommand extends ProductionCommand {
		private static final long serialVersionUID = -3597967446891551838L;

		public FarmGrainCommand(ProductionRoom room, Product product) {
			super(room, product);
		}

		@Override
		public String getCommandName() { return "Farm Grain"; }
	}
	
	public List<ProductionCommand> getProductionCommands() { return products; }
	
	public Command getBuildCommand(Lair lair) {
		FarmRoom room = new FarmRoom(lair);
		Cost cost = new Cost(6);
		return new BuildRoomCommand(room, cost);		
	}
}
