package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.Cost;

public abstract class CommerceCommand extends Command {
	protected Room room;
	protected Cost cost;
	public CommerceCommand(Player player, Room room, Cost cost) {
		super(player);
		this.room = room;
		this.cost = cost;
		LairList kingdom = room.getLair().getKingdom();
		enabled = CommerceUtils.canAfford(kingdom, cost);
		cost.increaseWaitTime(CommerceUtils.transferTime(kingdom, room.getLair(), cost));
	}

}
