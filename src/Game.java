import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener{
	
	private Snake snake = new Snake(20, 20, 320, 240);
	private AppleClass apple = new AppleClass(15, 15);
	private boolean gameOver = false;
	private int frames = 0;
	
	public Game(){
		this.setPreferredSize(new Dimension(640, 480));
		this.setBackground(Color.BLACK);
		
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	public void update() {
		
		if(gameOver) return;
		
		frames ++;
		
		if(frames > 12) {
			snake.tick();
			checkColision();
			checkGameOver();
			apple.gerarApple(snake);
			frames = 0;
		}
		

	}
	
	public void render() {
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GRAY);
		int tamanhoGrade = 20;
		
		for(int i = 0; i < 640; i += tamanhoGrade) {
			g.drawLine(i, 0, i, 480);
		}
		
		for(int i = 0; i < 480; i+= tamanhoGrade) {
			g.drawLine(0, i, 640, i);
		}
		
		g.setColor(Color.GREEN);
		for(int i = 0; i < snake.corpo.size(); i++) {
			Node n = snake.corpo.get(i);
			g.fillRect(n.x, n.y, snake.getWidth(), snake.getHeight());
		}
		
		g.setColor(Color.BLUE);
		g.fillRect(snake.positionX, snake.positionY, snake.getWidth(), snake.getHeight());
		
		g.setColor(Color.RED);
		g.fillOval(apple.positionX, apple.positionY, apple.getWidth(), apple.getHeight());
		
		if(gameOver) {
			g.setColor(new Color(0, 0, 0, 150));
			g.fillRect(0, 0, 640, 480);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			
			String texto = "GAME OVER !";
			int larguraTexto = g.getFontMetrics().stringWidth(texto);
			g.drawString(texto, (640 - larguraTexto) / 2, 240);
			
			g.setFont(new Font("Arial", Font.BOLD, 20));
			String texto2 = "pressione ENTER para reiniciar";
			int larguraTexto2 = g.getFontMetrics().stringWidth(texto2);
			g.drawString(texto2, (640 - larguraTexto2) / 2, 280);
		}
	}
	
	public void checkColision() {
		if(snake.getBounds().intersects(apple.getBounds())) {
			System.out.println("Comeu maça");
			apple.appeExist = false;
			snake.tamanho++;
		}
	}
	
	public void checkGameOver() {
		if(snake.positionX < 0 || snake.positionX >= 640 ||
		   snake.positionY < 0 || snake.positionY > 460) {
			gameOver = true;
		}
		
		for(int i = 0; i < snake.corpo.size(); i++) {
			Node n = snake.corpo.get(i);
			if(n.x == snake.positionX && n.y == snake.positionY) {
				gameOver = true;
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int cod = e.getKeyCode();
		
		int velX = snake.velX;
		int velY = snake.velY;
		
		if(gameOver) {
			if(cod == KeyEvent.VK_ENTER) {
				gameOver = false;
				snake = new Snake(20, 20, 320, 240);
				snake.corpo.clear();
				snake.tamanho = 3;
				frames = 0;
			}
		}
		
		if(cod == KeyEvent.VK_RIGHT && velX != -1) {
			snake.velX = 1;
			snake.velY = 0;
		}
		else if(cod == KeyEvent.VK_LEFT && velX != 1) {
			snake.velX = -1;
			snake.velY = 0;
		}
		else if(cod == KeyEvent.VK_UP && velY != 1) {
			snake.velY = -1;
			snake.velX = 0;
		}
		else if(cod == KeyEvent.VK_DOWN && velY != -1) {
			snake.velY = 1;
			snake.velX = 0;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
