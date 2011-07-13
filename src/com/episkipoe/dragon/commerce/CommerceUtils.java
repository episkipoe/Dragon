package com.episkipoe.dragon.commerce;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class CommerceUtils {
	private static Collection<TreasureList> listAvailableStores(LairList kingdom) {
		Set<TreasureList> stores = new LinkedHashSet<TreasureList>();
		for (Room r : kingdom.getAllRoomsOfType(TreasureRoom.class)) {
			TreasureRoom room = (TreasureRoom) r;	
			stores.add(room.getTreasureList());
		}
		for (Lair l : kingdom.getLairs()) {
			stores.add(l.getOwner().getInventory());
		}
		return stores;
	}
	
	public static boolean canAfford(LairList kingdom, Cost cost) {
		if(cost.getRequirements().isEmpty()) return true;
		TreasureList needToHave = new TreasureList(cost.getRequirements());
		if(needToHave.isEmpty()) return true;
		for(TreasureList tl : listAvailableStores(kingdom)) {
			needToHave.subtract(tl);
			if(needToHave.isEmpty()) return true;
		}
		return false;
	}
	public static boolean canAfford(Lair lair, Cost cost) {
		return canAfford(lair.getKingdom(), cost);
	}
	
	//TODO:  Roads to reduce transfer time, X,Y pos of lairs
	public static int transferTime(Lair lair, Cost cost) {
		TreasureList nearest = getNearestStore(lair);
		if(nearest==null) return 0;
		if(nearest.has(cost.getRequirements())) return 0;
		return 10;
	}
	public static boolean subtractCost(Lair lair, Cost cost) {
		LairList kingdom = lair.getKingdom();
		if(cost.getRequirements().isEmpty()) return true;
		TreasureList needToHave = new TreasureList(cost.getRequirements());
		TreasureList nearestTreasure = getNearestStore(lair);
		nearestTreasure.subtractCost(needToHave);
		if(needToHave.isEmpty()) return true;
		
		for(TreasureList tl : listAvailableStores(kingdom)) {
			tl.subtractCost(needToHave);
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
		if(room == null) {
			if(lair.getOwner()==null) { return null; }
			return lair.getOwner().getInventory();
		}
		TreasureRoom treasureRoom = (TreasureRoom)room;
		return treasureRoom.getTreasureList();
	}
}
	
