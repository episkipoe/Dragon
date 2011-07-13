package com.episkipoe.dragon.production;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commerce.RoomCommerceCommand;
import com.episkipoe.dragon.events.WaitEvent;
import com.episkipoe.dragon.lairs.Lair;

public class ProductionCommand extends RoomCommerceCommand {
	private static final long serialVersionUID = -6144942045547759137L;
	private ProductionRoom room;
	private Product product;
	private String commandName;
	public ProductionCommand(ProductionRoom room, Product product, String commandName) {
		super(room, product.getCost());
		this.room = room;
		this.product = product;
		this.commandName = commandName;
	}
	public String getCommandName() { return commandName; }

	public void onClick(View v) {
		if(product.skillCheck(Main.player.getPlayerAgent())) {
			Lair lair = room.getLair();
			new ProductionEvent(Main.player.getPlayerAgent(), lair, product);
			Main.player.popupNotify(getScheduleMessage());		
		} else {
			new WaitEvent(Main.player.getPlayerAgent().getEvents(), product.getCost().getWaitTime());
			Main.player.popupNotify(getFailMessage());		
		}
	}

	
	public String getScheduleMessage() { return "Production has been scheduled"; }
	public String getFailMessage() { return "Production has failed"; }
	public String getDescription() { return product.getCost().toString(); }
	final public Product getProduct() { return product; }

}
