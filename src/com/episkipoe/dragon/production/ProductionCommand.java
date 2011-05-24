package com.episkipoe.dragon.production;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;

public abstract class ProductionCommand extends Command {
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
		room.productionInProgress=true;
		setEnabled(false);
		//TODO schedule re-enabling of the command
	}

	
	public String getScheduleMessage() { return "Production has begun"; }
	public String getDescription() { return product.getCost().toString(); }
	final public Product getProduct() { return product; }

}
