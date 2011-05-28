package com.episkipoe.dragon.production;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.lairs.Lair;
import com.episkipoe.dragon.lairs.LairList;
import com.episkipoe.dragon.treasure.Treasure;
import com.episkipoe.dragon.treasure.TreasureList;

public class ProductionList implements Serializable {
	private static final long serialVersionUID = 1852921798653586688L;
	
	private List<Product> products;
	private Map<Product,Double> productionProbability;
	public ProductionList() { 
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
		TreasureList list = new TreasureList();
		list.add(resource);
		Product p = new Product(list);
		products.add(p);
		return p;
	}
	
	public void scheduleProduction(LairList kingdom, Lair from, Product p) {
		if(!products.contains(p)) return;
		new ProductionEvent(Main.player.getPlayerAgent(), kingdom, from, p);
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
