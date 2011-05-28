package com.episkipoe.dragon.guards;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.rooms.Room;

public class GuardUtils {
	//TODO GuardUtils
	public static boolean canSneakPastGuards(Room room, Agent agent, boolean notify) {
		AgentList guards = room.getGuards();
		if(guards == null) return true;

		return true;
	}
	
}
