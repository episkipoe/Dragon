package com.episkipoe.dragon.player;

import java.io.Serializable;

import android.widget.Toast;

public class PlayerSettings implements Serializable {
	private static final long serialVersionUID = 3357386620701696020L;
	
	public int toastDuration=Toast.LENGTH_SHORT;
	public int eventPeriod=10;
}
