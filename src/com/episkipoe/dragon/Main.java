package com.episkipoe.dragon;

import com.episkipoe.dragon.player.Player;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
public class Main extends Activity {
	Player player=null;;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        player = new Player(this);
        player.showMainPage();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
	    return player.onTouchEvent(event);
    }
}