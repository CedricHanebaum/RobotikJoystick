package snake;

public class Void implements GameObject{

	@Override
	public boolean collidable() {
		return false;
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
