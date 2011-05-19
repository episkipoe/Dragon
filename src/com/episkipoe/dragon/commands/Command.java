package com.episkipoe.dragon.commands;

import com.episkipoe.dragon.player.Player;

import android.widget.Button;
import android.view.View;

public abstract class Command implements View.OnClickListener {
	protected Player player;
	public Command(Player player) {
		this.player = player;
	} 
	
	/**
	 * 
	 * @return the name of the command
	 */
	abstract public String getName();

	final public Button getButton() { 
		Button btn = new Button(player.getActivity());
		btn.setText(getName());
		btn.setOnClickListener(this);
		return btn;
	}
	
}
