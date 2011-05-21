package com.episkipoe.dragon.rooms.treasure;

import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

class TreasureDisplay extends CommandPage {
	TreasureList treasures;
	protected TreasureDisplay(Player player, TreasureList treasures) {
		super(player);
		this.treasures=treasures;
	}

	@Override
	public String getCommandName() { return "Treasures"; }
	
	protected void addHeader(ViewGroup layout) { 
		if(treasures.getTreasures() == null) {
			TextView noneLbl = new TextView(player.getActivity());
			noneLbl.setText("There is no treasure in this room!");
			layout.addView(noneLbl);
			return;
		}
		
		TableLayout table = new TableLayout(player.getActivity());
		layout.addView(table);
		
		TableRow header = new TableRow(player.getActivity());
		table.addView(header);
		
		TextView typeLbl = new TextView(player.getActivity());
		typeLbl.setText("Treasure");
		header.addView(typeLbl);
		
		TextView qtyLbl = new TextView(player.getActivity());
		qtyLbl.setText("Quantity");
		header.addView(qtyLbl);
		
		TextView valLbl = new TextView(player.getActivity());
		valLbl.setText("Value");
		header.addView(valLbl);	
		
		for(Treasure t: treasures.getTreasures()) {
			TableRow row = new TableRow(player.getActivity());
			table.addView(row);
			
			TextView type = new TextView(player.getActivity());
			typeLbl.setText(t.getType());
			row.addView(type);
			
			TextView qty = new TextView(player.getActivity());
			qtyLbl.setText(String.valueOf(t.qty));
			row.addView(qty);
			
			TextView val = new TextView(player.getActivity());
			valLbl.setText(String.valueOf(t.getValue(player)));
			row.addView(val);				
		}
		
		TextView lbl = new TextView(player.getActivity());
		lbl.setText("Total Value: " + treasures.totalValue());
		layout.addView(lbl);
	}	
}
