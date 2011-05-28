package com.episkipoe.dragon.player;

import java.util.List;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.species.DragonAgent;
import com.episkipoe.dragon.lairs.KingdomBuilder;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;

public class PlayerUtils {

	public static void initializeTestPlayer(Player player, int nearbyKingdoms) throws Exception {
		List<Class<? extends Lair>> lairs = LairList.availableTypes();
		for (Class<? extends Lair> type : lairs) {
			Lair l;
			try {
				l = type.newInstance();
				l.setOwner(player.getPlayerAgent());
				player.getLairList().addLair(l);
			} catch(Exception e) {
				System.out.println("Failed to add lair of type: " + type.toString() + " because " + e.getMessage());
				continue;
			}
			//l.addAllRooms();
		}
		
		for(int i=0 ; i<nearbyKingdoms ; i++) {
			player.getNeighboringKingdoms().add(KingdomBuilder.create());
		}
	}
	
	public static Agent getPlayerAgent(Player player) {
		Agent dragon = new DragonAgent(2);
		dragon.setRelationship(Relationship.PLAYER);	
		return dragon;
	}
	

}
