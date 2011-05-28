package com.episkipoe.dragon.events;

import android.os.Handler;

public class EventThread extends Thread {
	  private Handler handler=null;
	  public Handler getHandler() {
		  if(handler==null) handler=new Handler();
		  return handler;
	  }

}
