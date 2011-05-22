package com.episkipoe.dragon.player;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.Agent.Relationship;
import com.episkipoe.dragon.agents.dragons.DragonAgent;
import com.episkipoe.dragon.agents.royalty.KingAgent;
import com.episkipoe.dragon.lairs.CastleLair;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.lairs.MountainLair;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.TreasureRoom;

public class PlayerUtils {

	public static void initializePlayer(Player player, int nearbyKingdoms) {
		Lair mountainLair = getMountainLair(player, player.getPlayerAgent(), 0);
		player.getLairList().addLair(mountainLair);
		
		for(int i=0 ; i<nearbyKingdoms ; i++) {
			Agent king = getKing(player);
			LairList kingdom = new LairList(player, king);
			Lair castle = getCastleLair(player, king, 3);
			kingdom.addLair(castle);
			player.getNeighboringKingdoms().add(kingdom);
		}
	}
	
	public static Agent getPlayerAgent(Player player) {
		DragonAgent dragon = new DragonAgent();
		dragon.setRelationship(Relationship.PLAYER);	
		return dragon;
	}
	
	public static Lair getMountainLair(Player player, Agent owner, int agents) {
		MountainLair mountain = new MountainLair(player, owner);
		Room treasure = new TreasureRoom(player, mountain);
		mountain.getRoomSet().add(treasure);	
		return mountain;
	}
	
	public static Agent getKing(Player player) {
		KingAgent king = new KingAgent();
		return king;
	}
	
	public static Lair getCastleLair(Player player, Agent owner, int agents) {
		CastleLair castle = new CastleLair(player, owner);
		Room treasure = new TreasureRoom(player, castle);
		castle.getRoomSet().add(treasure);	
		return castle;
	}
}
