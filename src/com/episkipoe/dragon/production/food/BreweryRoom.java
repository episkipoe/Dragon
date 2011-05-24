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
import com.episkipoe.dragon.treasure.TreasureList;

public class BreweryRoom extends ProductionRoom {
	List<ProductionCommand> products;
	public BreweryRoom() { }
	public BreweryRoom(Lair lair) {
		super(lair);
		products = new ArrayList<ProductionCommand>();
		
		Product ale = getAleProduct();
		getProductionList().addProduct(ale);
		products.add(new BrewAleCommand(this, ale));
	}
	
	private Product getAleProduct() {
		TreasureList requires = new TreasureList();
		requires.add(new GrainTreasure());
		Cost cost = new Cost(requires, 3);
		TreasureList produces = new TreasureList();
		produces.add(new AleTreasure());
		return new Product(cost, produces);
	}
	
	private class BrewAleCommand extends ProductionCommand {
		public BrewAleCommand(ProductionRoom room, Product product) {
			super(room, product);
		}

		@Override
		public String getCommandName() { return "Brew Ale"; }
	
	}
	
	@Override
	public String getCommandName() { return "Brewery"; }
	public List<ProductionCommand> getProductionCommands() { return products; }

	public Command getBuildCommand(Lair lair) {
		BreweryRoom room = new BreweryRoom(lair);
		Cost cost = new Cost(3);
		return new BuildRoomCommand(room, cost);
	}
}
