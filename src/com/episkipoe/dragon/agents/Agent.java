package com.episkipoe.dragon.agents;

import com.episkipoe.dragon.rooms.prison.Prisoner;


public abstract class Agent {
	public abstract String getType();
	
	private String name = "Unnamed";
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public enum Relationship { PLAYER, ALLY, ENEMY }
	private Relationship relationship=Relationship.ENEMY;

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public Prisoner toPrisoner() {
		return new Prisoner(this);
	}
}
