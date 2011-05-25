package com.episkipoe.dragon.agents;

import java.io.Serializable;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.attributes.AttributeSet;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.dungeon.Prisoner;
import com.episkipoe.dragon.rooms.Room;


public abstract class Agent implements Serializable {
	private static final long serialVersionUID = -3896345659032866402L;
	
	public Agent(int level) {
		for(int i=0;i<level;i++) levelUp();		
	} 
	
	public abstract String getType();
	
	private String name = "Unnamed";
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	public String getDescription() {
		return getName() + ": a level " + level + " " + getType();
	}
	
	private int level=0;
	public void setLevel(int level) { this.level = level; }
	public int getLevel() { return level; }
	public void levelUp() {
		level++;
		getAttributeSet().levelUp(this);
		if(Main.player != null && this == Main.player.getPlayerAgent()) { 
			Main.player.setCharacterLabel();
		}
	}
	
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
	
	AttributeSet attributeSet = null;
	public AttributeSet getAttributeSet() {
		if(attributeSet == null) attributeSet = new AttributeSet();
		return attributeSet;
	}

	public Prisoner toPrisoner() {
		return new Prisoner(this);
	}
}
