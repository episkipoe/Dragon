package com.episkipoe.dragon.agents;

import java.io.Serializable;

public class AgentMate implements Serializable {
	private static final long serialVersionUID = 2396013698390026610L;
	
	Agent thisAgent;
	AgentMate(Agent agent) {
		this.thisAgent = agent;
	}
	
	public enum Gender {MALE, FEMALE, BOTH, NEITHER};
	public Gender gender=Gender.MALE;
	
	public Agent mother=null;
	public Agent father=null;
	public Agent mate (Agent other) throws Exception {
		Class<? extends Agent> childType = thisAgent.getMateSpecies(other);
		if(childType == null) return null;
		Agent childFather=null;
		Agent childMother=null;
		if(gender==Gender.MALE) childFather=thisAgent;
		if(other.getAgentMate().gender==Gender.MALE) childFather=other;
		if(gender==Gender.FEMALE) childMother=thisAgent;
		if(other.getAgentMate().gender==Gender.FEMALE) childMother=other;	
		if(childFather==null || childMother==null) return null;
	
		Agent newAgent = childType.newInstance();
		newAgent.getAgentMate().mother = childMother;
		newAgent.getAgentMate().father = childFather;	
		return null;
	}
	
	public Agent mate () throws Exception {
		if(gender!=Gender.BOTH) return null;
		Agent newAgent = thisAgent.getClass().newInstance();
		newAgent.getAgentMate().mother = thisAgent;
		newAgent.getAgentMate().father = thisAgent;
		return newAgent;
	}
}
