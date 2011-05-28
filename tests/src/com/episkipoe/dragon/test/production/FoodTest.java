package com.episkipoe.dragon.test.production;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commerce.CommerceUtils;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.royal.CastleLair;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.ProductionCommand;
import com.episkipoe.dragon.production.food.AleTreasure;
import com.episkipoe.dragon.production.food.BreweryRoom;
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
		ProductionCommand farmGrain = farm.getProductionCommands().get(0);
		assertTrue(farmGrain.getProduct().getProduces().numTreasures() == 1);
		assertTrue(CommerceUtils.canAfford(castle, farmGrain.getProduct().getCost()));
		farmGrain.getProduct().produce(castle);
		assertTrue(farmGrain.getProduct().getProduces().numTreasures() == 1);
		assertTrue(farmGrain.getProduct().getProduces().has(GrainTreasure.class));
		assertTrue(store.has(GrainTreasure.class));
		assertTrue(store.get(GrainTreasure.class).qty == 2);
		assertFalse(store.has(AleTreasure.class));
		BreweryRoom b = new BreweryRoom();
		BuildRoomCommand buildBrewery = (BuildRoomCommand) b.getBuildCommand(castle);
		assertTrue(buildBrewery != null);
		buildBrewery.onClick(null);
		BreweryRoom brewery = (BreweryRoom) rooms.get(BreweryRoom.class);
		assertTrue(brewery != null);
		ProductionCommand brewAle = brewery.getProductionCommands().get(0);
		assertTrue(CommerceUtils.canAfford(castle, brewAle.getProduct().getCost()));
		brewAle.getProduct().produce(castle);
		assertTrue(store.has(AleTreasure.class));
		//System.out.println("has " + store.get(GrainTreasure.class).qty + " grain");
		assertTrue(store.get(GrainTreasure.class).qty == 1);
		brewAle.getProduct().produce(castle);
		assertTrue(store.get(AleTreasure.class).qty == 2);
		brewAle.getProduct().produce(castle);  //this should fail since we only have 2 grain
		assertTrue(store.get(AleTreasure.class).qty == 2);
	}
}
