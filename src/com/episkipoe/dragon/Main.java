package com.episkipoe.dragon;

import com.episkipoe.dragon.player.Player;

import android.app.Activity;
import android.os.Bundle;
public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Player player = new Player(this);
        setContentView(player.getActions());
    }
}