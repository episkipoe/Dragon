package com.episkipoe.dragon.lairs;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.events.Event;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;

public class AgentEnterLairEvent extends Event {
	private Agent agent;
	private Lair lair;
	public AgentEnterLairEvent(Player player, Agent agent, Lair lair) {
		super(player);
		this.agent = agent;
		this.lair = lair;
	}

	@Override
	public void run() {
		Room guardRoom = lair.getRoomSet().getRoom("Guard Tower");
		if(guardRoom == null) return;
		if(agent.getSkillSet().getSkillLevel("Sneak") > guardRoom.level) return ;
	}

	
}