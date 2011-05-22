package com.episkipoe.dragon.production;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.episkipoe.dragon.events.EventScheduler;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.treasure.Treasure;
import com.episkipoe.dragon.treasure.TreasureList;

public class ProductionList {
	private Player player;
	private List<Product> products;
	private Map<Product,Double> productionProbability;
	public ProductionList(Player player) { 
		this.player = player;
		products = new ArrayList<Product>();
		productionProbability = new HashMap<Product,Double> ();
	}

	public void increaseWaitTime(int seconds) { 
		for (Product p: products) p.getCost().increaseWaitTime(seconds);
	}

	public void addProduct(Product p, double probability) {
		products.add(p);
		productionProbability.put(p, probability);
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public Product addProduct(Treasure resource) {
		TreasureList list = new TreasureList(player);
		list.add(resource);
		Product p = new Product(list);
		products.add(p);
		return p;
	}
	
	public void scheduleProduction(LairList kingdom, Lair from, Product p) {
		if(!products.contains(p)) return;
		ProductionEvent event = new ProductionEvent(player, kingdom, from, p);
		EventScheduler.schedule(event, p.getCost().getWaitTime());
	}

	public void produce(LairList kingdom, Lair from) {
		Random rnd = new Random();
		for(Product p: products) {
			if(productionProbability.containsKey(p)) {
				double probability = productionProbability.get(p);
				if(probability < rnd.nextDouble()*100.0) continue;
			}
			p.produce(kingdom, from);
		}
	}
}
