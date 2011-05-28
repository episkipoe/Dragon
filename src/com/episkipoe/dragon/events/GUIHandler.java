package com.episkipoe.dragon.events;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.episkipoe.dragon.Main;

public class GUIHandler extends Handler {
	public static final int REFRESH = 0;
	public static final int NOTIFY  = 1;
	public void handleMessage(Message msg) {
		switch(msg.what) {
		case REFRESH:
			Main.player.getPageManager().refresh();
			break;
		case NOTIFY:
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
		h.sendMessage(notification);
	}
}
