package com.episkipoe.dragon.events;

import android.os.Handler;
import android.os.Looper;

public class EventThread extends Thread {
	public EventThread() { }
	
	private Handler handler=null;
	Handler getHandler() {
		if(handler==null) handler=new Handler();
		return handler;
	}
	
	public void run() {
		if(Looper.myLooper()==null) Looper.prepare();
		Looper.loop();	
	}
}
