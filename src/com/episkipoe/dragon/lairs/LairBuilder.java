package com.episkipoe.dragon.lairs;

import android.view.View;

import com.episkipoe.dragon.commands.Command;

public class LairBuilder extends Command {
	private static final long serialVersionUID = -6236471632114696733L;

	public LairBuilder() {
	}

	@Override
	public String getCommandName() { return "Add Lair"; }
	
	public void onClick(View v) {
		//TODO add lair
	}



}
