package com.episkipoe.dragon.agents;

import java.io.Serializable;

import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.rooms.dungeon.Prisoner;


public abstract class Agent implements Serializable {
	private static final long serialVersionUID = -3896345659032866402L;
	
	public abstract String getType();
	
	private String name = "Unnamed";
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	private int level=1;
	public void setLevel(int level) { this.level = level; }
	public int getLevel() { return level; }
	
	private Room location=null;
	public void setLocation(Room location) { this.location = location; }
	public Room getLocation() { return location; }
	
	public enum Relationship { PLAYER, ENEMY, NEUTRAL, ALLY }
	private Relationship relationship=Relationship.NEUTRAL;

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	SkillSet skillSet = null;
	public SkillSet getSkillSet() {
		if(skillSet == null) skillSet = new SkillSet();
		return skillSet;
	}

	public Prisoner toPrisoner() {
		return new Prisoner(this);
	}
}
