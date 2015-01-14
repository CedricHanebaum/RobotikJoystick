package snake;

public class Wall implements GameObject{

	@Override
	public boolean collidable() {
		return true;
	}

	@Override
	public boolean eatable() {
		return false;
	}

	@Override
	public int getPosX() {
		return -1;
	}

	@Override
	public int getPosY() {
		return -1;
	}

	@Override
	public void setPosX(int posX) {}

	@Override
	public void setPosY(int posY) {}

}
