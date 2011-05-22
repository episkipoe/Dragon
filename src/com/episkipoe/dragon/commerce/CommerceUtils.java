package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class CommerceUtils {
	public static boolean canAfford(LairList kingdom, Cost cost) {
		if(cost.getRequirements(kingdom.player).isEmpty()) return true;
		System.out.println("before:" + cost.getRequirements(kingdom.player).totalValue());
		TreasureList needToHave = new TreasureList(cost.getRequirements(kingdom.player));
		if(needToHave.isEmpty()) return true;
		for (Room r : kingdom.getAllRoomsOfType(TreasureRoom.class)) {
			TreasureRoom store = (TreasureRoom) r;
			needToHave.subtract(store.getTreasureList());
			System.out.println("\tafter:" + cost.getRequirements(kingdom.player).totalValue());
			if(needToHave.isEmpty()) return true;
		}
		return false;
	}
	public static boolean canAfford(Lair lair, Cost cost) {
		return canAfford(lair.getKingdom(), cost);
	}
	
	public static int transferTime(Lair lair, Cost cost) {
		LairList kingdom = lair.getKingdom();
		TreasureList nearest = getNearestStore(lair);
		if(nearest.has(cost.getRequirements(kingdom.player))) return 0;
		return 10;
	}
	public static boolean subtractCost(Lair lair, Cost cost) {
		LairList kingdom = lair.getKingdom();
		if(cost.getRequirements(kingdom.player).isEmpty()) return true;
		TreasureList needToHave = new TreasureList(cost.getRequirements(kingdom.player));
		TreasureList nearestTreasure = getNearestStore(lair);
		nearestTreasure.subtractCost(needToHave);
		if(needToHave.isEmpty()) return true;
		
		for (Room r : kingdom.getAllRoomsOfType(TreasureRoom.class)) {
			TreasureRoom store = (TreasureRoom) r;
			store.getTreasureList().subtractCost(needToHave);
			if(needToHave.isEmpty()) return true;
		}
		return false;
	}
	
	public static Room getNearestRoom(Lair lair, Class<? extends Room> type) {
		LairList kingdom = lair.getKingdom();
		if(lair.getRoomSet().has(type)) {
			return lair.getRoomSet().get(type);
		}
		for(Lair l: kingdom.getLairs()) {
			if(lair.getRoomSet().has(type)) {
				return (l.getRoomSet().get(type));
			}
		}
		return null;
	}
	
	public static TreasureList getNearestStore(Lair lair) {
		Room room = getNearestRoom(lair, TreasureRoom.class);
		if(room == null) return null;
		TreasureRoom treasureRoom = (TreasureRoom)room;
		return treasureRoom.getTreasureList();
	}
}
	
