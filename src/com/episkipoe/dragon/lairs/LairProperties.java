package com.episkipoe.dragon.lairs;

import java.io.Serializable;

import com.episkipoe.dragon.agents.AgentList;
import com.episkipoe.dragon.rooms.treasure.TreasureList;

public class LairProperties implements Serializable {
	private static final long serialVersionUID = 1747827587442152857L;
	
	TreasureList treasures;
	AgentList agents;
}
