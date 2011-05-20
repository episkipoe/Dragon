package com.episkipoe.dragon.commands;

import java.util.List;

import android.view.View;
import android.widget.LinearLayout;

import com.episkipoe.dragon.player.Player;

public abstract class CommandPage extends Command {
	protected CommandPage(Player player) {
		super(player);
	}

	protected List<Command> commandList;
	protected void prepareCommands() { }
	
	final public void onClick(View v) {
		player.getPageManager().next(getPage());
	}

	final public View getPage() {
		prepareCommands();
		
		LinearLayout layout = new LinearLayout(player.getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		if(commandList != null) {
			for(Command cmd : commandList) {
				layout.addView(cmd.getButton());
			}
		}
		layout.addView(player.getPageManager().getBackButton());
		
		return layout;
	}
}

