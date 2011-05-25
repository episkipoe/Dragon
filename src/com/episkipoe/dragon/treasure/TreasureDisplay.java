package com.episkipoe.dragon.treasure;

import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup;
import android.widget.TableLayout;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.GUI;

class TreasureDisplay extends CommandPage {
	private static final long serialVersionUID = -3496239085773165659L;
	Agent owner;
	TreasureList treasures;
	protected TreasureDisplay(Agent owner, TreasureList treasures) {
		this.owner=owner;
		this.treasures=treasures;
	}

	@Override
	public String getCommandName() { return "Treasures"; }
	
	protected void addHeader(ViewGroup layout) { 
		if(treasures.getTreasures() == null) {
			layout.addView(GUI.text("There is no treasure in this room!"));
			return;
		}
		
		TableLayout table = new TableLayout(Main.player.getActivity());
		layout.addView(table);
		
		List<String> header=new ArrayList<String>();
		header.add("Treasure");
		header.add("Quantity");
		header.add("Value");
		GUI.tableRow(table, header);
		
		table.setColumnStretchable(0, true);
		table.setColumnStretchable(1, true);
		for(Treasure t: treasures.getTreasures()) {
			List<String> row=new ArrayList<String>();
			row.add(t.getType());
			row.add(String.valueOf(t.qty));
			row.add(String.valueOf(t.getValue(owner)));
			GUI.tableRow(table, row);
		}

		layout.addView(GUI.text("Total Value: " + treasures.totalValue(owner)));
	}	
}
