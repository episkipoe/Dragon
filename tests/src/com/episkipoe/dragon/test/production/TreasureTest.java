package com.episkipoe.dragon.test.production;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.player.Player;
import com.episkipoe.dragon.production.building.WoodTreasure;
import com.episkipoe.dragon.production.food.AleTreasure;
import com.episkipoe.dragon.treasure.TreasureList;

public class TreasureTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public TreasureTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testTreasure() {
		Player player = new Player(this.getActivity());
		
		AleTreasure someAle = new AleTreasure(5);
		AleTreasure fiveAle = (AleTreasure) someAle.clone();
		assertTrue(fiveAle != null);
		someAle.qty = 0;
		assertTrue(fiveAle.qty == 5);
		
		TreasureList treasures = new TreasureList(player);
		assertTrue(treasures.numTreasures() == 0);
		treasures.add(fiveAle);

		assertTrue(treasures.getTreasures().size() == 1);
		assertTrue(treasures.numTreasures() == 1);
		
		assertTrue(treasures.has(AleTreasure.class));
		assertTrue(treasures.get(AleTreasure.class).qty == 5);
		assertFalse(treasures.has(WoodTreasure.class));
		treasures.add(new WoodTreasure(2));
		assertTrue(treasures.numTreasures() == 2);
		assertTrue(treasures.has(WoodTreasure.class));
		treasures.subtract(new AleTreasure(3));
		assertTrue(treasures.get(AleTreasure.class).qty == 2);
		assertTrue(fiveAle.qty == 5);
	}
	

}
