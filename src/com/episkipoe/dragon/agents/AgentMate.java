package com.episkipoe.dragon.agents;

import java.io.Serializable;

public class AgentMate implements Serializable {
	private static final long serialVersionUID = 2396013698390026610L;
	
	Agent thisAgent;
	AgentMate(Agent agent) {
		this.thisAgent = agent;
	}
	
	public enum Gender {MALE, FEMALE, BOTH, NEITHER};
	Gender gender=Gender.MALE;
	
	public boolean canMate (Agent other) { return true; }
	
	Agent mother=null;
	Agent father=null;
	public Agent mate (Agent other) {
		if(!canMate(other)) return null;
		return null;
	}
}
