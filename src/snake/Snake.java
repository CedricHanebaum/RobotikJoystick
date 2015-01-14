package snake;

public class Snake {

	private SnakePart head;
	private SnakePart tail;
	
	private Direction nextDir;
	private boolean hasEaten;
	private boolean hasCollided;
	
	public Snake(World w){
		head = new SnakePart();
		tail = new SnakePart();
		head.setNext(tail);
		tail.setLast(head);
		w.setObjectAt(World.WIDTH / 2, World.HEIGHT / 2, head);
		w.setObjectAt(World.WIDTH / 2 + 1, World.HEIGHT / 2, tail);
		
		nextDir = Direction.LEFT;
		hasEaten = false;
		hasCollided = false;
	}
	
	public void move(World w){
		int nx = head.getPosX();
		int ny = head.getPosY();
		
		switch(nextDir){
		case UP:
			ny += 1;
			break;
		case DOWN:
			ny += -1;
			break;
		case LEFT:
			nx += -1;
			break;
		case RIGHT:
			nx += 1;
			break;
		default:
			throw new RuntimeException("Wrong Direction");
		}
		
		if(w.getObjectAt(nx, ny).collidable()){
			hasCollided = true;
		} else {
			if(w.getObjectAt(nx, ny).eatable()){
				hasEaten = true;
				w.eatFood();
			}
			
			SnakePart nHead = new SnakePart();
			nHead.setNext(head);
			w.setObjectAt(nx, ny, nHead);
			head.setLast(nHead);
			head = nHead;
			
			if(!hasEaten){
				GameObject goVoid = new Void();
				w.setObjectAt(tail.getPosX(), tail.getPosY(), goVoid);
				
				tail = tail.getLast();
			} else {
				hasEaten = false;
			}
		}
	}
	
	public void setNextDir(Direction dir){
		if(dir == Direction.UP && nextDir == Direction.DOWN ||
				dir == Direction.DOWN && nextDir == Direction.UP ||
				dir == Direction.LEFT && nextDir == Direction.RIGHT ||
				dir == Direction.RIGHT && nextDir == Direction.LEFT){
			return;
		}
		nextDir = dir;
	}
	
	public boolean hasCollided(){
		return hasCollided;
	}
	
	public enum Direction{
		UP, DOWN, LEFT, RIGHT
	}
	
}
