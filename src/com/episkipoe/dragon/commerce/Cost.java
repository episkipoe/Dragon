package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.treasure.TreasureList;

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
	
	/**
	 * if greater than zero this cost can simply be paid, bypassing the TreasureList
	 */
	private int coinSubstitute=-1;
	public void setCoinSubstitute(int value) { coinSubstitute = value; }
	public int getCoinSubstitute() { return coinSubstitute; }
	public boolean canSubstituteCoin() {  return (coinSubstitute>0); }

	public void setRequirements(TreasureList requirements) { this.requirements = requirements; }
	public TreasureList getRequirements() { 
		if(requirements==null) requirements = new TreasureList();
		return requirements; 
	}

	public int getWaitTime() { return seconds; }
	public void setWaitTime(int seconds) { this.seconds = seconds; }
	public void increaseWaitTime(int seconds) { this.seconds += seconds; }
	public String toString() {
		if(isEmpty() && seconds <=0) {
			return "Free";
		}
		String cost = "";
		if(requirements!=null) {
			cost += requirements.toString() + " ";
		}
		if(seconds>0) cost += seconds + " seconds ";
		return cost;
	}
	public boolean isEmpty() { 
		return (requirements == null || requirements.numTreasures()==0);
	}
}
