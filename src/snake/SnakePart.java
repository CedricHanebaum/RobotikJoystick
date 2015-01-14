package snake;

import main.IDrawable;

public class SnakePart implements GameObject, IDrawable{

	private boolean visible;
	private SnakePart next;
	private SnakePart last;
	
	private int posX;
	private int posY;
	
	public SnakePart(){
		visible = true;
		next = null;
		
		posX = -1;
		posY = -1;
	}
	
	public void setNext(SnakePart next){
		this.next = next;
	}
	
	public SnakePart getNext(){
		return next;
	}
	
	public void setLast(SnakePart last){
		this.last = last;
	}
	
	public SnakePart getLast(){
		return last;
	}
	
	public void setVisible(boolean v){
		visible = v;
	}
	
	@Override
	public boolean collidable() {
		return true;
	}

	@Override
	public boolean eatable() {
		return false;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}

	@Override
	public void setPosX(int posX) {
		this.posX = posX;
	}

	@Override
	public void setPosY(int posY) {
		this.posY = posY;
	}

}
