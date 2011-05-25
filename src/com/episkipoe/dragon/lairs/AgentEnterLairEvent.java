package com.episkipoe.dragon.lairs;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.FearSkill;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.agents.skills.SkillUtils;
import com.episkipoe.dragon.agents.skills.SneakSkill;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.guards.GuardRoom;
import com.episkipoe.dragon.rooms.Room;

public class AgentEnterLairEvent extends Event {
	private Agent agent;
	private Lair lair;
	public AgentEnterLairEvent(Agent agent, Lair lair) {
		this.agent = agent;
		this.lair = lair;
	}

	@Override
	public void run() {
		Room guardRoom = lair.getRoomSet().get(GuardRoom.class);
		if(guardRoom == null) return;
		SkillSet agentSkills = agent.getSkillSet();
		SkillSet sneak = new SkillSet(agent, agentSkills.getSkill(SneakSkill.class));
		if(SkillUtils.skillCheck(sneak, guardRoom.level)) return ;
		SkillSet fear = new SkillSet(agent, agentSkills.getSkill(FearSkill.class));
		if(SkillUtils.skillCheck(fear, guardRoom.level)) return ;
		
		//TODO:  fear check / combat / fail / notify / etc
	}

	
}
