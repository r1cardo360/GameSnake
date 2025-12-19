import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		GameSnake gameloop = new GameSnake();
		
		JFrame janela = new JFrame("Snake Game");
		
		janela.add(gameloop.game);
		
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		gameloop.start();

	}

}
