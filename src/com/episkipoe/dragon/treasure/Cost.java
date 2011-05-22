package com.episkipoe.dragon.treasure;

public class Cost {
	private TreasureList requirements=null;
	private int seconds=0;
	public Cost() { }
	public Cost(int seconds) { 
		this.seconds = seconds;
	}
	public Cost(TreasureList requirements) {
		this.setRequirements(requirements);
	}
	public Cost(TreasureList requirements, int seconds) {
		this.seconds = seconds;
		this.setRequirements(requirements);
	}
	public void setRequirements(TreasureList requirements) {
		this.requirements = requirements;
	}
	public TreasureList getRequirements() {
		return requirements;
	}
	public boolean meetsRequirements(TreasureList treasures) {
		if(requirements==null) return true;
		for(Treasure t : requirements.getTreasures()) {
			if(!treasures.hasTreasure(t.getType())) return false;
			Treasure has = treasures.getTreasure(t.getType());
			if(has.qty < t.qty) return false;
		}
		return true;
	}
	public int getWaitTime() { return seconds; }
	public String toString() {
		if(requirements == null && seconds <=0) {
			return "Free";
		}
		String cost = "";
		if(requirements!=null) {
			cost += requirements.toString() + " ";
		}
		if(seconds>0) cost += seconds + " seconds ";
		return cost;
	}
}
