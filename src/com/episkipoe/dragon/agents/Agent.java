package com.episkipoe.dragon.agents;

import java.io.Serializable;

import com.episkipoe.dragon.agents.attributes.AttributeSet;
import com.episkipoe.dragon.agents.classes.AgentClass;
import com.episkipoe.dragon.agents.classes.AgentClassSet;
import com.episkipoe.dragon.agents.skills.Skill;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.events.EventQueue;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.Treasure;
import com.episkipoe.dragon.treasure.TreasureList;


public abstract class Agent implements Serializable {
	private static final long serialVersionUID = -3896345659032866402L;
	
	public Agent() { }
	public Agent(int level) {
		setLevel(level);
	} 
	
	public void setLevel(int level) {
		for(int i=0;i<level;i++) levelUp();		
		postCreate();	
	}

	/*
	 * Methods that must be overridden
	 */
	public abstract String getType();
	public abstract Command getHireCommand(Room room, int level) ;

	
	/*
	 * Methods that can/should be overridden
	 */
	
	/**
	 * 
	 * @param type
	 * @return is this agent able to use this skill
	 */
	public boolean can(Class<? extends Skill> type) {
		Skill s;
		try {
			s = type.newInstance();
		} catch(Exception e) {
			return false;
		}
		for(AgentClass c : getClassSet().getAgentClasses()) {
			if(c.enablesSkill(type)) return true;
		}
		return s.canByDefault();
	}
	public boolean canConsume(Class<? extends Treasure> foodClass) { return false; }
	
	/**
	 * 
	 * @return if this agent mates with the other agent, what species (if any) is produced
	 *  (e.g.  Human + Human = Human,  Human + Elf = HalfElf)
	 */
	public Class<? extends Agent> getMateSpecies(Agent other) {  
		if(this.getClass() == other.getClass()) return this.getClass();
		return null;
	}
	
	/**
	 * Called after new level is applied, any specific benefits should occur here
	 */
	public void postLevelUp() { }

	/**
	 * Called after an agent is created and leveled up. 
	 * put any Agent-specific initialization in here
	 */
	public void postCreate() { }
	
	/*
	 * Utility methods
	 */
	private String name = "Unnamed";
	final public void setName(String name) { this.name = name; }
	final public String getName() { return name; }
	final public String getDescription() {
		return getName() + ": a level " + level + " " + getType();
	}

	private int level=0, XP=0;
	final public int getLevel() { return level; }
	final private void levelUp() {
		level++;
		getAttributeSet().levelUp(this);
		postLevelUp();
	}
	final public void awardXP(int XP) { 
		this.XP += XP;
		int nextLevelAt = 10+10*(level * level * (level/2));
		if(this.XP >= nextLevelAt) levelUp();
	}
	
	private Room location=null;
	final public void setLocation(Room location) { this.location = location; }
	final public Room getLocation() { return location; }
	
	public enum Relationship { PLAYER, ENEMY, NEUTRAL, ALLY }
	private Relationship relationship=Relationship.NEUTRAL;
	final protected Relationship getRelationship() { return relationship; }
	final public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}
	final public static Relationship getRelationship(Agent other) {
		if(other==null) return Relationship.NEUTRAL;
		return other.getRelationship();
	}

	private AgentAction action = null;
	final public AgentAction getAction() {
		if(action==null) action = new AgentAction(this);
		return action;
	}
	
	private AgentClassSet classSet = null;
	final public AgentClassSet getClassSet() {
		if(classSet==null) classSet = new AgentClassSet();
		return classSet;
	}
	
	private AttributeSet attributeSet = null;
	final public AttributeSet getAttributeSet() {
		if(attributeSet == null) attributeSet = new AttributeSet();
		return attributeSet;
	}
	
	private SkillSet skillSet = null;
	final public SkillSet getSkillSet() {
		if(skillSet == null) skillSet = new SkillSet();
		return skillSet;
	}

	private AgentMate mate=null;
	final public AgentMate getAgentMate() {
		if(mate==null) mate = new AgentMate(this);
		return mate;
	}
	
	private TreasureList inventory=null;
	final public TreasureList getInventory() {
		if(inventory==null) inventory = new TreasureList();
		return inventory;
	}
	
	private EventQueue events=null;
	public EventQueue getEvents() {
		if(events==null) events = new EventQueue();
		return events;
	}
	public void addEvent(Event event) {
		getEvents().add(event);
	}

}
