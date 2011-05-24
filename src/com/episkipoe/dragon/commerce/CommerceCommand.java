package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.rooms.Room;

public abstract class CommerceCommand extends Command {
	protected Room room;
	protected Cost cost;
	public CommerceCommand(Room room, Cost cost) {
		this.room = room;
		this.cost = cost;
		LairList kingdom = room.getLair().getKingdom();
		setEnabled(CommerceUtils.canAfford(kingdom, cost));
		cost.increaseWaitTime(CommerceUtils.transferTime(room.getLair(), cost));
	}
	public Cost getCost() { return cost; } 

}
