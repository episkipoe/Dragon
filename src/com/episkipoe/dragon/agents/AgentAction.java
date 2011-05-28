package com.episkipoe.dragon.agents;

import java.io.Serializable;

public class AgentAction implements Serializable {
	private static final long serialVersionUID = -3979827318043355417L;

	Agent agent;
	AgentAction(Agent agent) {
		this.agent = agent;
	}
	
	public void add() {
		
	}

}
