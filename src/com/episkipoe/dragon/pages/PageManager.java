package com.episkipoe.dragon.pages;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.player.Player;

public class PageManager {
	Player player = null;
	ViewFlipper flipper=null;
	public PageManager (Player player) {
		this.player = player;
	}

	int pageDepth=0;
	public void setView(View view) {
		ScrollView scrollView = new ScrollView(player.getActivity());
		flipper = new ViewFlipper(player.getActivity());
		flipper.setMeasureAllChildren(false);
		scrollView.addView(flipper);
		pageDepth=0;
		flipper.addView(view);
		player.getActivity().setContentView(scrollView);	
	}
	
	public void refresh() {
		if(flipper==null) return;
		View currentView = flipper.getChildAt(pageDepth);
		if(currentView==null) return;
		CommandPage page = (CommandPage) currentView.getTag();
		if(page==null) return;
		flipper.setInAnimation(null);
		flipper.setOutAnimation(null);
		flipper.removeViewAt(pageDepth);
		flipper.addView(page.getPage());
		flipper.showNext();	
	}

	public void next(View view) {
		flipper.addView(view);
		flipper.setInAnimation(inFromRightAnimation());
		flipper.setOutAnimation(outToLeftAnimation());
		pageDepth++;
		flipper.showNext();	
	}

	public Button getBackButton() { 
		Button btn = new Button(player.getActivity());
		btn.setText("Back");
		btn.setOnClickListener(getBackClick());
		return btn;
	}	

	private void back() {
		if(pageDepth<=0) return; 
		flipper.setInAnimation(inFromLeftAnimation());
		flipper.setOutAnimation(outToRightAnimation());
		flipper.showPrevious();
		flipper.removeViewAt(pageDepth);
		pageDepth--;
	}

	private class BackClick implements View.OnClickListener {
		public void onClick(View v) {
			back();
		}
	}
	BackClick backClick=null;
	private BackClick getBackClick() { 
		if(backClick==null) backClick = new BackClick();
		return backClick;
	}

	protected Animation inFromRightAnimation() {
		Animation inFromRight = new TranslateAnimation(
			Animation.RELATIVE_TO_PARENT, +1.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(500);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;
	}

	protected Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, -1.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(500);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	protected Animation inFromLeftAnimation() {
		Animation inFromLeft = new TranslateAnimation(
			Animation.RELATIVE_TO_PARENT, -1.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromLeft.setDuration(500);
		inFromLeft.setInterpolator(new AccelerateInterpolator());
		return inFromLeft;
	}

	protected Animation outToRightAnimation() {
		Animation outtoRight = new TranslateAnimation(
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, +1.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f,
			Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(500);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		return outtoRight;
	}

	class SwipeDetector extends SimpleOnGestureListener {
		private static final int SWIPE_MIN_DISTANCE = 120;
		private static final int SWIPE_MAX_OFF_PATH = 250;
		private static final int SWIPE_THRESHOLD_VELOCITY = 200;

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) return false;
			if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
				//next
			} else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
				back();
				return true;
			}			
			return false;
		}	
	}
	GestureDetector swipeDetector=null;
	public boolean onTouchEvent(MotionEvent event) {
		if(swipeDetector==null) swipeDetector = new GestureDetector(new SwipeDetector());
		return swipeDetector.onTouchEvent(event);
	}

}
