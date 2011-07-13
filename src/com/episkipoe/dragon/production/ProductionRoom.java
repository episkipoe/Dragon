package com.episkipoe.dragon.production;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.RaidCommand;

public abstract class ProductionRoom extends Room {
	private static final long serialVersionUID = -8274655596305471194L;
	public ProductionRoom() { }
	public ProductionRoom(Lair lair) {
		super(lair);
	}
	
	abstract public List<Class<? extends ProductionTreasure>> getProductTypes(); 
	abstract public List<Class<? extends Agent>> getSpecies(); 	

	final public void prepareCommands() {
		commandList = new ArrayList<Command>();
		commandList.addAll(getProductionRoomCommands());
		commandList.addAll(getHireCommands());
	}
	
	final public List<Command> getHireCommands() { 
		List<Command> cmds = new ArrayList<Command>();
		for(Class<? extends Agent> type : getSpecies()) {
			try {
				Agent agent = type.newInstance();
				cmds.add(agent.getHireCommand(this, getLevel()));
			} catch (Exception e) {
				System.out.println("getHireCommand failed: " + e.getMessage());
			}
		}
		return cmds;
	}	
	
	final public List<Command> getProductionRoomCommands() {
		List<Command> cmds = new ArrayList<Command>();
		switch(Agent.getRelationship(lair.getOwner())) {
		case PLAYER:
			for(Class<? extends ProductionTreasure> type : getProductTypes()) {
				try {
					ProductionTreasure p = type.newInstance();
					cmds.add(p.getProductionCommand(this));
				} catch(Exception e) {
					System.out.println("getProductionCommand failed: " + e.getMessage());
				}
			}
			break;	
		case NEUTRAL: case ENEMY:
			cmds.add(new RaidCommand(lair, lair.getOwnerAndType()));
			break;
		}
		return cmds;
	}
	
	public void scheduleEvents() { 
		for(Agent a: getEmployees().getAvailable(this)) {
			for(Class<? extends ProductionTreasure> type : getProductTypes()) {
				try {
					ProductionTreasure p = type.newInstance();
					Product product = p.getProduct(this.getLevel());
					if(!CommerceUtils.canAfford(this.getLair().getKingdom(), product.getCost())) continue;
					if(product.skillCheck(a)) {
						a.addEvent(new ProductionEvent(a, this.getLair(), product));
						break;
					}
				} catch(Exception e) {
					System.out.println("schedule events failed: " + e.getMessage());
				}
			}
		}
	}
	

	@Override
	public void postCreate(int level) {
		if(level<=1) return;
		Random rnd = new Random();
		int numEmployees = rnd.nextInt(level);
		List<Class<? extends Agent>> agentTypes = getSpecies(); 	
		for(int i = 0 ; i < numEmployees ; i++) {
			int agentLevel = rnd.nextInt(level);
			int agentIdx = rnd.nextInt(agentTypes.size());
			try {
				Agent agent = agentTypes.get(agentIdx).newInstance();
				agent.setLevel(agentLevel);
				hireAgent(agent);
			} catch (Exception e) {
				System.out.println("Exception hiring agent: " + e.getMessage());
			}
		}
	}

}
