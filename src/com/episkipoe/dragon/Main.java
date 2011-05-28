package com.episkipoe.dragon;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.episkipoe.dragon.player.Player;
public class Main extends Activity {
	public static Player player=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        	Player.loadGame(this);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not load player: " + e.getMessage());
		}
		if(player==null) {
			try {
				Player.newGame(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
	    return player.onTouchEvent(event);
    }
    public void onSaveInstanceState(Bundle b) {
    	try {
			player.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	super.onPause();
	}
    public void onRestoreInstanceState(Bundle b) {
    	try {
        	player = Player.load(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	super.onResume();
    }
}