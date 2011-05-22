package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionCommand;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.rooms.BuildRoomCommand;

public class FarmRoom extends ProductionRoom {
	List<ProductionCommand> products;
	public FarmRoom(Player player, Lair lair) {
		super(player, lair);
		products = new ArrayList<ProductionCommand>();
		
		Product grain = getProductionList().addProduct(new GrainTreasure(2));
		products.add(new FarmGrainCommand(player, this, grain));
	}

	@Override
	public String getCommandName() { return "Farm"; }

	private class FarmGrainCommand extends ProductionCommand {
		public FarmGrainCommand(Player player, ProductionRoom room, Product product) {
			super(player, room, product);
		}

		@Override
		public String getCommandName() { return "Farm Grain"; }
	}
	
	public List<ProductionCommand> getProductionCommands() { return products; }
	
	public static Command getBuildCommand(Player player, Lair lair) {
		FarmRoom room = new FarmRoom(player, lair);
		Cost cost = new Cost(4);
		return new BuildRoomCommand(player, room, cost);		
	}
}
