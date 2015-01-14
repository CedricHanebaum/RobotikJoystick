package snake;

import lejos.nxt.Button;
import main.Game;
import main.Joystick;

public class GameSnake extends Game{

	private Snake snake;
	private World world;
	private LabelGO lgo;
	
	private Joystick j;
	
	public GameSnake(){
		super();
		j = new Joystick();
		lgo = new LabelGO();
	}
	
	@Override
	protected void init() {
		world = new World();
		snake = new Snake(world);
		
		lgo.setVisible(false);
		
		drawManager.clear();
		drawManager.addDrawable(world);
		drawManager.addDrawable(lgo);
	}

	@Override
	protected void calc() {
		if(!snake.hasCollided()){
			if(!world.hasFood()){
				world.spawnFood();
			}
			
			j.readValues();
			if(j.getHorizontalPos() > 20){
				snake.setNextDir(Snake.Direction.RIGHT);
			}
			if(j.getHorizontalPos() < -20){
				snake.setNextDir(Snake.Direction.LEFT);
			}
			if(j.getVerticalPos() > 20){
				snake.setNextDir(Snake.Direction.UP);
			}
			if(j.getVerticalPos() < -20){
				snake.setNextDir(Snake.Direction.DOWN);
			}
			
			snake.move(world);
			
			if(snake.hasCollided()){
				lgo.setVisible(true);
			}
		} else {
			if(Button.ENTER.isDown()){
				init();
			}
		}
	}

}
