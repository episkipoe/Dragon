package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.agents.species.DwarfAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionCommand;
import com.episkipoe.dragon.production.ProductionEvent;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.treasure.TreasureList;

public class BreweryRoom extends ProductionRoom {
	private static final long serialVersionUID = 8794169756942869835L;
	
	List<ProductionCommand> products;
	public BreweryRoom() { }
	public BreweryRoom(Lair lair) {
		super(lair);
		products = new ArrayList<ProductionCommand>();
		
		Product ale = getAleProduct();
		getProductionList().addProduct(ale);
		products.add(new BrewAleCommand(this, ale));
	}
	
	static public Product getAleProduct() {
		TreasureList requires = new TreasureList();
		requires.add(new GrainTreasure());
		Cost cost = new Cost(requires, 3);
		TreasureList produces = new TreasureList();
		produces.add(new AleTreasure());
		Product ale = new Product(cost, produces, 5);
		SkillSet skills = new SkillSet(new BrewSkill());
		ale.setSkillRequirements(skills);
		return ale;
	}
	
	private class BrewAleCommand extends ProductionCommand {
		private static final long serialVersionUID = -4665415979701491950L;

		public BrewAleCommand(ProductionRoom room, Product product) {
			super(room, product);
		}

		@Override
		public String getCommandName() { return "Brew Ale"; }
	
	}
	
	@Override
	public String getCommandName() { return "Brewery"; }
	public List<ProductionCommand> getProductionCommands() { return products; }
	
	public List<Command> getHireCommands() { 
		List<Command> cmds = new ArrayList<Command>();
		cmds.add(DwarfAgent.hireCommand(this, level));
		return cmds;
	}
	
	public void scheduleEvents() { 
		for(Agent a: getEmployees().getAvailable(this)) {
			Product ale = getAleProduct();
			if(ale.skillCheck(a)) {
				a.addEvent(new ProductionEvent(a, this.getLair(), ale));
			}
		}
	}
	
	public Command getBuildCommand(Lair lair) {
		BreweryRoom room = new BreweryRoom(lair);
		Cost cost = new Cost(3);
		return new BuildRoomCommand(room, cost);
	}
	
	@Override
	public void postCreate(int level) {
		Random rnd = new Random();
		int numEmployees = rnd.nextInt(level);
		for(int i = 0 ; i < numEmployees ; i++) {
			int agentLevel = rnd.nextInt(level);
			hireAgent(new DwarfAgent(agentLevel));
		}
	}
}
