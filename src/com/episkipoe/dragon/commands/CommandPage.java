package com.episkipoe.dragon.commands;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.episkipoe.dragon.player.Player;

public abstract class CommandPage extends Command {
	protected CommandPage(Player player) {
		super(player);
	}

	protected List<Command> commandList;
	protected void prepareCommands() { }
	protected void addHeader(ViewGroup layout) { }
	
	final public void onClick(View view) {
		player.getPageManager().next(getPage());
	}

	final public View getPage() {
		prepareCommands();
		LinearLayout layout = new LinearLayout(player.getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		TextView title = new TextView(player.getActivity());
		title.setText(getCommandName());
		layout.addView(title);
		addHeader(layout);
		
		if(commandList != null) {
			for(Command cmd : commandList) {
				cmd.addToLayout(layout);
			}
		}
		layout.addView(player.getPageManager().getBackButton());
		layout.setTag(this);
		
		return layout;
	}
}

