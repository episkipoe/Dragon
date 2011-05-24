package com.episkipoe.dragon.treasure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.episkipoe.dragon.agents.Agent;

public class TreasureList implements Serializable {
	private static final long serialVersionUID = 2490515336611342772L;
	
	public TreasureList() {
		treasures = new HashMap<Class<? extends Treasure>,Treasure>();
	}
	public TreasureList(TreasureList orig) {
		treasures = new HashMap<Class<? extends Treasure>,Treasure>();
		add(orig);
	}
	
	public String getName() { return "View Treasures"; }
	
	private Map<Class<? extends Treasure>,Treasure> treasures;
	public void add(Treasure t) { 
		Treasure cur = get(t.getClass());
		if(cur==null) {
			cur = t.clone();
			set(cur);
		}  else {
			cur.qty += t.qty;
		}
	}
	public void add(TreasureList treasureList) {
		for(Treasure t : treasureList.getTreasures()) {
			add(t);
		}
	}
	/**
	 * Removes the quantity of treasure from the list
	 * NOTE:  this can result in debt (negative quantity in the list)
	 * @param t
	 */
	public void subtract(Treasure t) {
		Treasure cur = get(t.getClass());
		if(cur!=null) {
			cur.qty -= t.qty;
		}
	}
	public void subtract(TreasureList treasureList) {
		for(Treasure t : treasureList.getTreasures()) {
			subtract(t);
		}
	}
	/**
	 * Subtracts treasure from both the list and the cost and does not result in negative values in this list
	 * 
	*/
	public void subtractCost(TreasureList cost) {
		for(Treasure t : cost.getTreasures()) {
			Treasure cur = get(t.getClass());
			if(cur==null) continue;
			int qtyToSubtract=Math.min(cur.qty, t.qty);
			cur.qty -= qtyToSubtract;
			t.qty -= qtyToSubtract;
		}
	}
	private void set(Treasure t) { treasures.put(t.getClass(),t); }
	public void remove(Class<? extends Treasure> type) { treasures.remove(get(type)); }
	public void removeEmpty() {
		for(Iterator<Treasure> iter = treasures.values().iterator() ; iter.hasNext(); ) {
			Treasure t = iter.next();
			if(t.qty <= 0) iter.remove();
		}
	}

	public boolean has(Class<? extends Treasure> type) { return treasures.containsKey(type); }
	public boolean has(TreasureList treasureList) {
		for(Treasure t : treasureList.getTreasures()) {
			Treasure cur = get(t.getClass());
			if(cur==null) return false;	
			if(cur.qty < t.qty) return false;
		}
		return true;
	}
	public Treasure get(Class<? extends Treasure> type) { return treasures.get(type); }
	public int numTreasures() { return treasures.size(); }
	
	public int totalValue(Agent agent) { 
		int value=0;
		for (Treasure t: getTreasures()) value += t.getValue(agent);
		return value;
	}

	public boolean isEmpty() {
		if(numTreasures() == 0) return true;
		for(Treasure t: getTreasures()) {
			if(t.qty > 0) return false;
		}
		return true;
	}
	public Collection<Treasure> getTreasures () { return treasures.values(); }
	
	public String toString () {
		List<String> descriptions = new ArrayList<String>();
		for(Treasure t : getTreasures()) descriptions.add(t.toString());
		return StringUtils.join(descriptions, ", ");
	}
	
}
