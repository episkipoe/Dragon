package com.episkipoe.dragon.production;

import android.view.View;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.player.Player;

public abstract class ProductionCommand extends Command {
	private ProductionRoom room;
	private Product product;
	public ProductionCommand(Player player, ProductionRoom room, Product product) {
		super(player);
		this.room = room;
		this.product = product;
	}

	public void onClick(View v) {
		Lair lair = room.getLair();
		LairList kingdom = lair.getKingdom();
		room.getProductionList().scheduleProduction(kingdom, lair, product);
		player.popupNotify(getScheduleMessage());
		enabled = false;
		//EventScheduler.schedule(new ReEnable(player, this), 5);
	}
	

	
	public String getScheduleMessage() { return "Production has begun"; }
	public String getDescription() { return product.getCost().toString(); }
	final public Product getProduct() { return product; }

}
