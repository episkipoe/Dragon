package com.episkipoe.dragon.lairs;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentEvent;
import com.episkipoe.dragon.agents.skills.FearSkill;
import com.episkipoe.dragon.agents.skills.SkillUtils;
import com.episkipoe.dragon.agents.skills.SneakSkill;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.rooms.Room;

public class AgentEnterLairEvent extends AgentEvent {
	private static final long serialVersionUID = -6119531399118569988L;
	
	private Lair lair;
	public AgentEnterLairEvent(Agent agent, Lair lair, int delay) {
		super(agent, delay);
		this.agent = agent;
		this.lair = lair;
	}

	@Override
	public void run() {
		Room guardRoom = lair.getRoomSet().get(GuardRoom.class);
		if(guardRoom == null) return;
		if(SkillUtils.skillCheck(agent, SneakSkill.class, guardRoom.getLevel())) return ;
		if(SkillUtils.skillCheck(agent, FearSkill.class, guardRoom.getLevel())) return ;
		
		//TODO:  consequences of failing enter lair check
		postRun();
	}

	
}
