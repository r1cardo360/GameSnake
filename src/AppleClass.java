import java.awt.Rectangle;

public class AppleClass {

	private int width;
	private int height;
	public int positionX;
	public int positionY;
	public boolean appeExist = false;
	
	public AppleClass(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {return this.width;}
	public int getHeight() {return this.height;}
	
	public void gerarApple(Snake snake) {
		if(!this.appeExist) {
			
			boolean nasceuEmCimaDaCobra = false;
			
			do {
				nasceuEmCimaDaCobra = false;
				
				int sorteioX = (int) (Math.random() * 31);
				this.positionX = (sorteioX * 20) + 2;
				
				int sorteioY = (int) (Math.random()* 23);
				this.positionY = (sorteioY * 20) + 2;
				
				if(this.positionX == snake.positionX && this.positionY == snake.positionY) {
					nasceuEmCimaDaCobra = true;
				}
				
				for(Node n : snake.corpo) {
					if(this.positionX == n.x && this.positionY == n.y) {
						nasceuEmCimaDaCobra = true;
						break;
					}
				}
				
			}while(nasceuEmCimaDaCobra);

		}
		this.appeExist = true;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.positionX, this.positionY, this.width, this.height);
	}
	
}
