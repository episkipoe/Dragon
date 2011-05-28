package com.episkipoe.dragon.production.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.agents.species.ElfAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.production.Product;
import com.episkipoe.dragon.production.ProductionCommand;
import com.episkipoe.dragon.production.ProductionEvent;
import com.episkipoe.dragon.production.ProductionRoom;
import com.episkipoe.dragon.rooms.BuildRoomCommand;

public class FarmRoom extends ProductionRoom {
	private static final long serialVersionUID = -2818358797223917564L;
	
	List<ProductionCommand> products;
	public FarmRoom() { }
	public FarmRoom(Lair lair) {
		super(lair);
		products = new ArrayList<ProductionCommand>();
		
		getProductionList().addProduct(getGrainProduct());
		products.add(new FarmGrainCommand(this, getGrainProduct()));
	}

	static public Product getGrainProduct() {
		Product grain = new Product(new GrainTreasure(2), 4);
		grain.getCost().increaseWaitTime(5);
		SkillSet skills = new SkillSet(new FarmSkill());
		grain.setSkillRequirements(skills);
		return grain;
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
	
	public List<Command> getHireCommands() { 
		List<Command> cmds = new ArrayList<Command>();
		cmds.add(ElfAgent.hireCommand(this, level));
		return cmds;
	}
	
	public void scheduleEvents() { 
		for(Agent a: getEmployees().getAvailable(this)) {
			Product grain = getGrainProduct();
			if(grain.skillCheck(a)) {
				a.addEvent(new ProductionEvent(a, this.getLair(), grain));
			}
		}
	}	
	
	public Command getBuildCommand(Lair lair) {
		FarmRoom room = new FarmRoom(lair);
		Cost cost = new Cost(6);
		return new BuildRoomCommand(room, cost);		
	}
	
	@Override
	public void postCreate(int level) {
		Random rnd = new Random();
		int numEmployees = rnd.nextInt(level);
		for(int i = 0 ; i < numEmployees ; i++) {
			int agentLevel = rnd.nextInt(level);
			hireAgent(new ElfAgent(agentLevel));
		}
	}	
}
