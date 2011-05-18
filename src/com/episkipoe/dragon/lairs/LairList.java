package com.episkipoe.dragon.lairs;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LairList implements View.OnClickListener {
	Activity activity;
	public LairList(Activity activity) {
		this.activity = activity;
	}
	List<Lair> lairs;
	public void addLair(Lair l) { lairs.add(l); }
	public List<Lair> getLairs() { return lairs; }

	/*
	 * UI
	 */
	
	public Button getButton(Context c) { 
		Button manageLairs = new Button(c);
		manageLairs.setText("Manage Lairs");	
		manageLairs.setOnClickListener(this);
		return manageLairs;
	}
	
	public void onClick(View v) {
		System.out.println("clicked");
		activity.setContentView(getActions());
	}
	
	View getActions() {
		LinearLayout layout = new LinearLayout(activity);

		Button btn = new Button(activity);
		btn.setText("test");	
		btn.setOnClickListener(this);
		layout.addView(btn);
		
		return layout;
	}
}