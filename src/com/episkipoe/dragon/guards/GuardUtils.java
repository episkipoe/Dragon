package com.episkipoe.dragon.guards;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.agents.skills.PerceptionSkill;
import com.episkipoe.dragon.agents.skills.SkillSet;
import com.episkipoe.dragon.agents.skills.SkillUtils;
import com.episkipoe.dragon.agents.skills.SneakSkill;
import com.episkipoe.dragon.rooms.Room;

public class GuardUtils {
	public static boolean canSneakPastGuards(Room room, Agent agent, boolean notify) {
		AgentList guards = room.getGuards();
		if(guards == null) return true;
		SkillSet sneak = new SkillSet(agent.getSkillSet().getSkill(SneakSkill.class));
		for(Agent g : guards.getAgents()) {
			SkillSet notice = new SkillSet(g.getSkillSet().getSkill(PerceptionSkill.class));
			if (!SkillUtils.skillCheck(sneak, notice)) return false;
		}
		return true;
	}
	
	//TODO combat
}
