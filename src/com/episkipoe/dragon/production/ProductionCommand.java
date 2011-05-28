package com.episkipoe.dragon.production;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commerce.RoomCommerceCommand;
import com.episkipoe.dragon.lairs.Lair;

public abstract class ProductionCommand extends RoomCommerceCommand {
	private static final long serialVersionUID = -6144942045547759137L;
	private ProductionRoom room;
	private Product product;
	public ProductionCommand(ProductionRoom room, Product product) {
		super(room, product.getCost());
		this.room = room;
		this.product = product;
	}

	public void onClick(View v) {
		if(product.skillCheck(Main.player.getPlayerAgent())) {
			Lair lair = room.getLair();
			room.getProductionList().scheduleProduction(lair, product);
			Main.player.popupNotify(getScheduleMessage());		
		} else {
			Main.player.popupNotify(getFailMessage());		
		}
	}

	
	public String getScheduleMessage() { return "Production has been scheduled"; }
	public String getFailMessage() { return "Production has failed"; }
	public String getDescription() { return product.getCost().toString(); }
	final public Product getProduct() { return product; }

}
