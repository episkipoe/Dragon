package com.episkipoe.dragon.commerce;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.rooms.Room;

/**
 *  This class stores a {@link Room} and a {@link Cost} and increases the cost based on transferring goods from across the {@link LairList} Kingdom
 *
 */
public abstract class RoomCommerceCommand extends Command {
	private static final long serialVersionUID = -2463715709626206147L;
	protected Room room;
	protected Cost cost;
	public RoomCommerceCommand(Room room, Cost cost) {
		this.room = room;
		this.cost = cost;
		LairList kingdom = room.getLair().getKingdom();
		setEnabled(CommerceUtils.canAfford(kingdom, cost));
		cost.increaseWaitTime(CommerceUtils.transferTime(room.getLair(), cost));
	}
	public Cost getCost() { return cost; } 

}
