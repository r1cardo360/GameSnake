
public class GameSnake implements Runnable{
	
	private boolean isRunning;
	private Thread th;
	private double FPS = 60.0;
	private final double ns = 1000000000 / FPS;
	public Game game = new Game();
	
	
	public void start() {
		if(isRunning) return;
		
		isRunning = true;
		th = new Thread(this);
		th.start();
	}
	
	public void stop() {
		isRunning = false;
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double delta = 0;
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1) {
				game.update();
				game.render();
				delta--;
			}
		}
	}
	
}
