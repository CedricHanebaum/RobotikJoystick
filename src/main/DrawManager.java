package main;

import java.util.ArrayList;

import lejos.nxt.LCD;

public class DrawManager {
	
	private ArrayList<IDrawable> drawList;
	
	public DrawManager(){
		drawList = new ArrayList<IDrawable>();
		LCD.setAutoRefresh(false);
	}
	
	public void addDrawable(IDrawable d){
		int i;
		for(i = 0; i < drawList.size() && drawList.get(i).getPriority() > d.getPriority(); ++i);
		drawList.add(i, d); //XXX evtl i + 1?
	}
	
	public void removeDrawable(IDrawable d){
		drawList.remove(d);
	}
	
	public void draw(){
		LCD.clear();
		for(int i = 0; i < drawList.size(); ++i){
			if(drawList.get(i).isVisible()){
				drawList.get(i).draw();
			}
		}
		LCD.refresh();
	}
	
	public int getListLength(){
		return drawList.size();
	}
	
	public void clear(){
		drawList.clear();
	}

}
