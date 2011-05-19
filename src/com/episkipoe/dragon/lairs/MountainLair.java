package com.episkipoe.dragon.lairs;

import com.episkipoe.dragon.player.Player;

import android.content.Context;
import android.widget.Button;

public class MountainLair extends Lair {
	public MountainLair(Player player) {
		super(player);
	}

	public String getName() { return "Mountain Lair"; }

	public void acquireWealth(Context c) { 
		Button btn = new Button(c);
		btn.setText("Mine for gold");
	}
}
