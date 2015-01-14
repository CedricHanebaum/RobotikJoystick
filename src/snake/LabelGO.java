package snake;

import lejos.nxt.LCD;
import main.IDrawable;

public class LabelGO implements IDrawable{
	
	private boolean visible;

	@Override
	public void draw() {
		for(int x = 20; x < 85; ++x){
			for(int y = 30; y < 40; ++y){
				LCD.setPixel(x, y, 0);
			}
		}
		
		LCD.drawString("GAME OVER!", 4, 4);
		
		drawLine(20, 30, 85, 30);
		drawLine(20, 40, 85, 40);
	}

	private void drawLine(int x1, int y1, int x2, int y2){
		int dx, dy;
		
		dx = x2 - x1;
		dy = y2 - y1;
		
		if(dx < dy){
			int tmp = x1;
			x1 = x2;
			x2 = tmp;
			dx = x2 - x1;
		}
		
		for(int x = x1; x < x2; ++x){
			int y = y1 + dy * (x - x1) / dx;
			LCD.setPixel(x, y, 1);
		}
	}
	
	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

}
