package com.episkipoe.dragon.lairs;

import java.util.List;
import java.util.Random;

import com.episkipoe.dragon.agents.Agent;

public class KingdomBuilder {

	public static LairList create() throws Exception {
		List<Class<? extends Lair>> mainLairs = LairList.seatsOfGovernment();
		Random rnd = new Random();
		int idx = rnd.nextInt(mainLairs.size());
		Class<? extends Lair> type = mainLairs.get(idx);
		Lair lair = type.newInstance();
		if(!lair.createOwner()) return null;
		Agent owner = lair.getOwner();
		LairList kingdom = new LairList(owner);
		kingdom.addLair(lair);
		List<Class<? extends Lair>> subLairs = lair.getSubLairs();
		if(subLairs.size()<=0) { return kingdom; }
		for(int i=0; i < owner.getLevel() ; i++) {
			idx = rnd.nextInt(subLairs.size());
			Lair newLair = subLairs.get(idx).newInstance();
			newLair.setOwner(owner);
			kingdom.addLair(newLair);
		}

		return kingdom;
	}
}
