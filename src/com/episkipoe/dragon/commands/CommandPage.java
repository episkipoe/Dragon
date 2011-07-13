package com.episkipoe.dragon.commands;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.episkipoe.dragon.Main;

/**
 * A collection of {@link Command}s
 *
 */
public abstract class CommandPage extends Command {
	private static final long serialVersionUID = 4070075706658130691L;
	
	protected CommandPage() { }

	protected List<Command> commandList;
	protected void prepareCommands() { }
	protected void addHeader(ViewGroup layout) { }
	
	final public void onClick(View view) {
		Main.player.getPageManager().next(getPage());
	}
	protected boolean hasBackButton() { return true; }
	final public View getPage() {
		prepareCommands();
		
		LinearLayout layout = new LinearLayout(Main.player.getActivity());
		layout.setTag(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		TextView title = new TextView(Main.player.getActivity());
		title.setText(getCommandName());
		layout.addView(title);
		addHeader(layout);
		table(layout);
		if(hasBackButton()) {
			layout.addView(Main.player.getPageManager().getBackButton());
		}
		return layout;
	}
	
	final public void table(ViewGroup layout) {
		if(commandList == null) { return; }
		TableLayout table = new TableLayout(Main.player.getActivity());
		layout.addView(table);	
		for(Command cmd : commandList) {
			if(cmd != null) cmd.addToTable(table);
		}
	}
	
	final public void linear(ViewGroup layout) {
		if(commandList == null) { return; } 
		for(Command cmd : commandList) {
			if(cmd != null) cmd.addToLayout(layout);
		}
	}
}

