package com.episkipoe.dragon.commands;

import com.episkipoe.dragon.player.Player;

import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

public abstract class Command implements View.OnClickListener {
	protected Player player;
	protected boolean enabled=true;
	public Command(Player player) {
		this.player = player;
	} 
	
	/**
	 * 
	 * @return the name of the command (ie text to show on button)
	 */
	abstract public String getCommandName();
	/**
	 * 
	 * @return an optional description (ie a label to accompany the button)
	 */
	public String getDescription() { return null; }

	final private Button getButton() { 
		Button btn = new Button(player.getActivity());
		btn.setText(getCommandName());
		btn.setOnClickListener(this);
		btn.setEnabled(enabled);
		return btn;
	}
	
	final private TextView getDescriptionLabel() {
		String description = getDescription();
		if(description==null) return null;
		TextView lbl = new TextView(player.getActivity());
		lbl.setText(description);
		return lbl;
	}
	
	final public void addToLayout(ViewGroup layout) {
		layout.addView(getButton());
		TextView lbl = getDescriptionLabel();
		if(lbl != null) layout.addView(lbl);
	}
}
