package com.episkipoe.dragon.commands;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.episkipoe.dragon.Main;

public abstract class CommandPage extends Command {
	private static final long serialVersionUID = 4070075706658130691L;
	
	protected CommandPage() { }

	protected List<Command> commandList;
	protected void prepareCommands() { }
	protected void addHeader(ViewGroup layout) { }
	
	final public void onClick(View view) {
		Main.player.getPageManager().next(getPage());
	}

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
		layout.addView(Main.player.getPageManager().getBackButton());
		return layout;
	}
	
	final public void table(ViewGroup layout) {
		TableLayout table = new TableLayout(Main.player.getActivity());
		layout.addView(table);	
		if(commandList != null) {
			for(Command cmd : commandList) {
				cmd.addToTable(table);
			}
		}
	}
	
	final public void linear(ViewGroup layout) {
		if(commandList != null) {
			for(Command cmd : commandList) {
				cmd.addToLayout(layout);
			}
		}
	}
}

