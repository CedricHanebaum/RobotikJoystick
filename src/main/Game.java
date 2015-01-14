package main;

public abstract class Game {
	
	public static final int TICKRATE = 500;
	
	private boolean isRunning;
	private int tick;
	protected DrawManager drawManager;
	
	public Game(){
		drawManager = new DrawManager();
		isRunning = false;
		tick = 0;
	}
	
	private void step(){
		calc();
		drawManager.draw();
	}
	
	public final void start(){
		isRunning = true;
		init();
		
		while(isRunning){
			step();
			try {
				Thread.sleep(TICKRATE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			++tick;
		}
	}
	
	public final void stop(){
		isRunning = false;
	}
	
	protected final int getTick(){
		return tick;
	}
	
	protected abstract void init();
	protected abstract void calc();

}
