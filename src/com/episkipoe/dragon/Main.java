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
			player = new Player(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
        player.showMainPage();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
	    return player.onTouchEvent(event);
    }
}