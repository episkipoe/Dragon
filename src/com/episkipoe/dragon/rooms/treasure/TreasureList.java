package com.episkipoe.dragon.rooms.treasure;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.episkipoe.dragon.player.Player;

public class TreasureList {
	Player player;
	public TreasureList(Player player) {
		this.player = player;
		treasures = new TreeMap<String,Treasure>();
	}
	
	public String getName() { return "View Treasures"; }
	
	private Map<String,Treasure> treasures;
	public void add(Treasure t) { 
		String type = t.getType();
		Treasure cur = getTreasure(type);
		if(cur==null) {
			setTreasure(type, t);
		}  else {
			cur.qty += t.qty;
		}
	}
	public void setTreasure(String type, Treasure t) { treasures.put(type,t); }
	public void removeTreasure(String type) { treasures.remove(getTreasure(type)); }
	public boolean hasTreasure(String type) { return treasures.containsKey(type); }
	public Treasure getTreasure(String type) { return treasures.get(type); }
	public int numTreasures() { return treasures.size(); }
	
	public int totalValue() { 
		int value=0;
		for (Treasure t: getTreasures()) value += t.getValue(player);
		return value;
	}

	public Collection<Treasure> getTreasures () { return treasures.values(); }
	
}
