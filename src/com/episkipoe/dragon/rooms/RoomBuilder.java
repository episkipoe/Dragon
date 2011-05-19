package com.episkipoe.dragon.rooms;

import com.episkipoe.dragon.player.Player;

import android.content.Context;
import android.view.View;
import android.widget.Button;

class RoomBuilder implements View.OnClickListener {
	Player player;
	public RoomBuilder (Player player) {
		this.player = player;
	}
	public Button getButton(Context c) { 
		Button btn = new Button(c);
		btn.setText("room");
		btn.setOnClickListener(this);
		return btn;
	}

	public View chooseRoom() {
		return null;
	}

	public void onClick(View v) {
		player.getActivity().setContentView(chooseRoom());
	}
}

