package com.episkipoe.dragon.player;

import java.util.Collection;

import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import com.episkipoe.dragon.Main;

public class GUI {
	public static TextView text(String txt) {
		TextView lbl = new TextView(Main.player.getActivity());
		lbl.setText(txt);
		return lbl;
	}
	public static void tableRow (TableLayout table, Collection<String> content) {
		LayoutParams params = new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);	
	
		TableRow row = new TableRow(Main.player.getActivity());
		table.addView(row, params);
		for(String s: content) {
			TextView lbl = text(s);
			row.addView(lbl);
		}
	}
}
