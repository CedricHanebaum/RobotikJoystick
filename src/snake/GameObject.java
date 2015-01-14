package snake;

public interface GameObject {
	
	public boolean collidable();
	public boolean eatable();
	
	public int getPosX();
	public int getPosY();
	
	public void setPosX(int posX);
	public void setPosY(int posY);

}
