import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	private int width;
	private int height;
	public int positionX;
	public int positionY;
	public int velX = 1;
	public int velY = 0;
	
	public ArrayList<Node> corpo = new ArrayList();
	public int tamanho = 3;
	
	public Snake(int width, int height, int positionX, int positionY) {
		this.width = width;
		this.height = height;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public int getWidth(){return this.width;}
	public int getHeight() {return this.height;}
	
	public void tick() {
		
		corpo.add(new Node(this.positionX, this.positionY));
		
		if(corpo.size() > tamanho) {
			corpo.remove(0);
		}
		
		this.positionX += velX * 20;
		this.positionY += velY * 20;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.positionX, this.positionY, this.width, this.height);
	}
	
	
}
