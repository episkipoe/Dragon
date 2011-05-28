package com.episkipoe.dragon.lairs.royal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentMate.Gender;
import com.episkipoe.dragon.agents.classes.royalty.KingClass;
import com.episkipoe.dragon.agents.classes.royalty.QueenClass;
import com.episkipoe.dragon.agents.species.HumanAgent;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.dungeon.DungeonRoom;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.lairs.BuildLairCommand;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.VillageLair;
import com.episkipoe.dragon.production.food.BreweryRoom;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class CastleLair extends Lair {
	private static final long serialVersionUID = 8633086528040582046L;

	public CastleLair() { }
	public CastleLair(Agent owner) {
		super(owner);
	}

	@Override
	public String getCommandName() { return "Castle"; }
	
	public List<Class<? extends Room>> getAllowedRooms() { 
		List<Class<? extends Room>> rooms = new ArrayList<Class<? extends Room>>(); 
		rooms.add(DungeonRoom.class);
		rooms.add(BreweryRoom.class);
		rooms.add(FarmRoom.class);
		rooms.addAll(getCommonRooms());
		return rooms; 
	}
	

	public boolean createOwner() {
		Random rnd = new Random();
		int level = 2+rnd.nextInt(20);
		HumanAgent ruler = new HumanAgent(level);
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
		if(level>15) {
			roomsToBuild.add(DungeonRoom.class);
		}
		if(level>8) {
			roomsToBuild.add(BreweryRoom.class);
		}
		if(level>3) {
			roomsToBuild.add(FarmRoom.class);
		}
		roomsToBuild.add(TreasureRoom.class);
		addRoomList(roomsToBuild, level);
	}
	
	public List<Class<? extends Lair>> getSubLairs() {
		List<Class<? extends Lair>> subLairs = new ArrayList<Class<? extends Lair>> ();
		subLairs.add(CityLair.class);
		subLairs.add(VillageLair.class);
		return subLairs;
	}
	@Override
	public Command getBuildCommand(LairList kingdom) {
		CastleLair lair = new CastleLair(Main.player.getPlayerAgent());
		Cost cost = new Cost(1);
		return new BuildLairCommand(kingdom, lair, cost); 
	}

}
