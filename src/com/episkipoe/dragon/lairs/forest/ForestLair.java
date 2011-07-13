package com.episkipoe.dragon.lairs.forest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentMate.Gender;
import com.episkipoe.dragon.agents.classes.royalty.KingClass;
import com.episkipoe.dragon.agents.classes.royalty.QueenClass;
import com.episkipoe.dragon.agents.species.ElfAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.lairs.BuildLairCommand;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.mountain.MountainLair;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.production.food.ForestRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class ForestLair extends Lair {
	private static final long serialVersionUID = 3850483969987761618L;
	
	public ForestLair() { }
	public ForestLair(Agent owner) {
		super(owner);
	}
	
	@Override
	public String getCommandName() { return "Forest Lair"; }
	
	public List<Class<? extends Room>> getAllowedRooms() { 
		List<Class<? extends Room>> rooms = new ArrayList<Class<? extends Room>>(); 
		rooms.add(ForestRoom.class);
		rooms.addAll(getCommonRooms());
		return rooms; 
	}
	
	public boolean createOwner() {
		Random rnd = new Random();
		int level = 2+rnd.nextInt(20);
		Agent ruler = new ElfAgent(level);
		if(rnd.nextBoolean()) {
			ruler.getAgentMate().gender = Gender.MALE;
			ruler.getClassSet().add(new KingClass(level));
		} else {
			ruler.getAgentMate().gender = Gender.FEMALE;
			ruler.getClassSet().add(new QueenClass(level));
		}
		setOwner(ruler);
		return true;
	}
	
	public void postCreate(int level) {
		List<Class<? extends Room>> roomsToBuild = new ArrayList<Class<? extends Room>>();
		if(level>20) {
			roomsToBuild.add(GuardRoom.class);
		}		
		if(level>3) {
			roomsToBuild.add(FarmRoom.class);
		}
		roomsToBuild.add(TreasureRoom.class);
		addRoomList(roomsToBuild, level);
	}	
	
	public List<Class<? extends Lair>> getSubLairs() {
		List<Class<? extends Lair>> subLairs = new ArrayList<Class<? extends Lair>> ();
		subLairs.add(MountainLair.class);
		return subLairs;
	}	
	
	@Override
	public Command getBuildCommand(LairList kingdom) {
		MountainLair lair = new MountainLair(Main.player.getPlayerAgent());
		Cost cost = new Cost(1);
		return new BuildLairCommand(kingdom, lair, cost); 
	}

}
