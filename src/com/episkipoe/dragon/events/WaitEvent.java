package com.episkipoe.dragon.events;

public class WaitEvent extends Event {
	private static final long serialVersionUID = 5313763063299778917L;
	public WaitEvent(EventQueue queue, int delay) {
		super(queue, delay);
	}
	public void run() { postRun(); }
}
