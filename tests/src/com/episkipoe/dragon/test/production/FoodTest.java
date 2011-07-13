package com.episkipoe.dragon.test.production;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.royal.CastleLair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.food.FarmRoom;
import com.episkipoe.dragon.production.food.GrainTreasure;
import com.episkipoe.dragon.rooms.BuildRoomCommand;
import com.episkipoe.dragon.rooms.RoomSet;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class FoodTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public FoodTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testBrewing() throws Exception {
		Player player = new Player(this.getActivity());
		Agent playerAgent = player.getPlayerAgent();
		LairList kingdom = player.getLairList();
		CastleLair castle = new CastleLair(playerAgent);
		kingdom.addLair(castle);
		TreasureRoom storeRoom = new TreasureRoom(castle);
		RoomSet rooms = castle.getRoomSet();
		rooms.add(storeRoom);
		TreasureList store = CommerceUtils.getNearestStore(castle);
		assertTrue(store!=null);
		assertFalse(store.has(GrainTreasure.class));
		assertFalse(castle.getRoomSet().buildQueued(FarmRoom.class));
		FarmRoom f = new FarmRoom();
		BuildRoomCommand buildFarm = (BuildRoomCommand) f.getBuildCommand(castle);
		assertTrue(buildFarm != null);
		buildFarm.onClick(null);
		assertTrue(castle.getRoomSet().buildQueued(FarmRoom.class));
		FarmRoom farm = (FarmRoom) rooms.get(FarmRoom.class);
		assertTrue(farm != null);
		//TODO  restore food test
	}
}
