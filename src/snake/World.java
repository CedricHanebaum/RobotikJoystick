package snake;

import java.util.Random;

import lejos.nxt.LCD;
import main.IDrawable;

public class World implements IDrawable{
	
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	
	private GameObject[][] world;
	private boolean hasFood;
	
	public World(){
		world = new GameObject[WIDTH][HEIGHT];
		
		for(int i = 0; i < WIDTH; ++i){
			for(int j = 0; j < HEIGHT; ++j){
				world[i][j] = new Void();
			}
		}
		
		for(int i = 0; i < WIDTH; ++i){
			setObjectAt(i, 0, new Wall());
			setObjectAt(i, HEIGHT - 1, new Wall());
		}
		
		for(int i = 0; i < HEIGHT; ++i){
			setObjectAt(0, i, new Wall());
			setObjectAt(WIDTH - 1, i, new Wall());
		}
		
		hasFood = false;
	}
	
	public GameObject getObjectAt(int x, int y){
		if(x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT){
			throw new RuntimeException("World Out of Bounds!");
		}
		
		return world[x][y];
	}
	
	public void spawnFood(){
		Random r = new Random();
		int x, y;
		do{
			x = r.nextInt(WIDTH);
			y = r.nextInt(HEIGHT);
		} while (world[x][y].collidable());
		
		GameObject food = new Food();
		setObjectAt(x, y, food);
		
		hasFood = true;
	}
	
	public void eatFood(){
		hasFood = false;
	}
	
	public boolean hasFood(){
		return hasFood;
	}
	
	public void setObjectAt(int x, int y, GameObject go){
		if(x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT){
			throw new RuntimeException("World Out of Bounds!");
		}
		
		world[x][y] = go;
		
		go.setPosX(x);
		go.setPosY(y);
	}

	@Override
	public void draw() {
		for(int i = 0; i < WIDTH; ++i){
			for(int j = 0; j < HEIGHT; ++j){
				int x = i * 2;
				int y = j * 2;
				
				if(world[i][j] instanceof Wall){
					LCD.setPixel(x, y, 1);
					LCD.setPixel(x + 1, y + 1, 1);
				}
				if(world[i][j] instanceof SnakePart){
					LCD.setPixel(x, y, 1);
					LCD.setPixel(x + 1, y, 1);
					LCD.setPixel(x, y + 1, 1);
					LCD.setPixel(x + 1, y + 1, 1);
				}
				if(world[i][j] instanceof Food){
					LCD.setPixel(x + 1, y, 1);
					LCD.setPixel(x, y + 1, 1);
				}
				if(world[i][j] instanceof Void){
					LCD.setPixel(x, y, 0);
					LCD.setPixel(x + 1, y, 0);
					LCD.setPixel(x, y + 1, 0);
					LCD.setPixel(x + 1, y + 1, 0);
				}
			}
		}
	}

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

}
