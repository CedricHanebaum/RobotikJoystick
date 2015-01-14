package main;

import lejos.nxt.Motor;

public class Joystick {

	private int horizontal;
	private int vertical;
	
	public Joystick(){
		horizontal = 0;
		vertical = 0;
		
		Motor.A.flt();
		Motor.B.flt();
	}
	
	public void readValues(){
		horizontal = Motor.B.getTachoCount();
		vertical = Motor.A.getTachoCount();
	}
	
	public int getVerticalPos(){
		return vertical;
	}
	
	public int getHorizontalPos(){
		return horizontal;
	}
	
	public void reset(){
		horizontal = 0;
		vertical = 0;
		
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		
		Motor.A.flt();
		Motor.B.flt();
	}
	
}
