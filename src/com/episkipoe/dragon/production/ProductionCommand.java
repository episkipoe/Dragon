package com.episkipoe.dragon.production;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;

public abstract class ProductionCommand extends Command {
	private static final long serialVersionUID = -6144942045547759137L;
	private ProductionRoom room;
	private Product product;
	public ProductionCommand(ProductionRoom room, Product product) {
		this.room = room;
		this.product = product;
	}

	public void onClick(View v) {
		Lair lair = room.getLair();
		LairList kingdom = lair.getKingdom();
		room.getProductionList().scheduleProduction(kingdom, lair, product);
		Main.player.popupNotify(getScheduleMessage());
	}

	
	public String getScheduleMessage() { return "Production has been scheduled"; }
	public String getDescription() { return product.getCost().toString(); }
	final public Product getProduct() { return product; }

}
