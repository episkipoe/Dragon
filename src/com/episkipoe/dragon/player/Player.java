package com.episkipoe.dragon.player;

import com.episkipoe.dragon.lairs.LairList;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

public class Player {
	LairList lairs;
	public LairList getLairList() { return lairs; }

	Activity activity;
	public Player(Activity activity) {
		this.activity = activity;
		lairs = new LairList(activity);
	}

	public View getActions() {
		LinearLayout layout = new LinearLayout(activity);

		layout.addView(lairs.getButton(activity));
		return layout;
	}
	

	
}
