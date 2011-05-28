package com.episkipoe.dragon.events;

import com.episkipoe.dragon.Main;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class GUIHandler extends Handler {
	public static final int REFRESH = 0;
	public static final int NOTIFY  = 1;
	public void handleMessage(Message msg) {
		System.out.println("recv'd msg: " + msg.what);
		switch(msg.what) {
		case REFRESH:
			Main.player.getPageManager().refresh();
			break;
		case NOTIFY:
			System.out.println("Toast: " + msg.obj.toString() + " or " + (String)msg.obj);
			Toast toast = Toast.makeText(Main.player.getActivity(), (String) msg.obj, Main.player.getSettings().toastDuration);	
			toast.show();
			break;
		}
	}	
	
	public static void popupNotify(GUIHandler h, String text) {
		Message notification = Message.obtain();
		notification.what=NOTIFY;
		notification.setTarget(h);
		notification.obj = text;
		boolean sent = h.sendMessage(notification);
		System.out.println("notify: " + text + " (sent) " + sent);
	}
}
