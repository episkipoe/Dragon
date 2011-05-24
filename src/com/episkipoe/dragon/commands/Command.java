package com.episkipoe.dragon.commands;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.events.Event;

public abstract class Command implements View.OnClickListener {
	private boolean enabled=true;
	public Command() { } 
	
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

	private Button btn=null;
	final private Button getButton() { 
		btn = new Button(Main.player.getActivity());
		btn.setText(getCommandName());
		btn.setOnClickListener(this);
		btn.setEnabled(enabled);
		return btn;
	}
	
	final public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(btn!=null) {
			btn.setEnabled(enabled);
		} 
	}
	
	final private TextView getDescriptionLabel() {
		String description = getDescription();
		if(description==null) return null;
		TextView lbl = new TextView(Main.player.getActivity());
		lbl.setText(description);
		return lbl;
	}
	
	final public void addToLayout(ViewGroup layout) {
		layout.addView(getButton());
		TextView lbl = getDescriptionLabel();
		if(lbl != null) layout.addView(lbl);
	}
	
	final public void addToTable(TableLayout table) {
		TableRow row = new TableRow(Main.player.getActivity());
		LayoutParams params = new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);	
		table.addView(row, params);
		
		row.addView(getButton());	
		
		TextView lbl = getDescriptionLabel();
		if(lbl != null) row.addView(lbl);
	}
	
	protected class ReEnable extends Event {
		Command cmd;
		public ReEnable(Command cmd) {
			this.cmd = cmd;
		}
		@Override
		public void run() {
			cmd.enabled = true;
			Main.player.getPageManager().refresh();
		} 
		
	}
}
