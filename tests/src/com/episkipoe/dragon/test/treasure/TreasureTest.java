package com.episkipoe.dragon.test.treasure;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.production.building.IronTreasure;
import com.episkipoe.dragon.production.building.WoodTreasure;
import com.episkipoe.dragon.production.food.AleTreasure;
import com.episkipoe.dragon.production.food.GrainTreasure;
import com.episkipoe.dragon.production.food.MushroomTreasure;
import com.episkipoe.dragon.treasure.Treasure;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.gems.DiamondTreasure;
import com.episkipoe.dragon.treasure.gems.GoldTreasure;

public class TreasureTest extends android.test.ActivityInstrumentationTestCase2<Main> {
	public TreasureTest() { 
		super("com.episkipoe.dragon", Main.class);
	}
	
	public void testTreasure() throws Exception {
		List<Class<? extends Treasure>> treasures = new ArrayList<Class<? extends Treasure>>();
		treasures.add(MushroomTreasure.class);
		treasures.add(AleTreasure.class);
		treasures.add(GrainTreasure.class);
		treasures.add(IronTreasure.class);
		treasures.add(WoodTreasure.class);
		treasures.add(DiamondTreasure.class);
		treasures.add(GoldTreasure.class);
		for(Class<? extends Treasure> type : treasures) {
			Treasure t = type.newInstance();
			assertTrue(t.qty==1);
		}
	}
	public void testTreasureList() {
		AleTreasure someAle = new AleTreasure(5);
		AleTreasure fiveAle = (AleTreasure) someAle.clone();
		assertTrue(fiveAle != null);
		someAle.qty = 0;
		assertTrue(fiveAle.qty == 5);
		
		TreasureList treasures = new TreasureList();
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
