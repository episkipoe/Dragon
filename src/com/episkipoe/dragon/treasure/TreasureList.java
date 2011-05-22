package com.episkipoe.dragon.treasure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.episkipoe.dragon.player.Player;

import org.apache.commons.lang.StringUtils;

public class TreasureList implements Serializable {
	private static final long serialVersionUID = 2490515336611342772L;
	
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
	
	public String toString () {
		List<String> descriptions = new ArrayList<String>();
		for(Treasure t : getTreasures()) descriptions.add(t.toString());
		return StringUtils.join(descriptions, ", ");
	}
	
}