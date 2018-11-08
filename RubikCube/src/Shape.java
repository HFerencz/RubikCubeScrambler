import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
	private int x1,y1,width,height;
	private Color color;
	private Color borderColor;
	
	
	//default constructor
	public Shape() {
		
	}
	
	public Shape(int x1, int y1, int width, int height, Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.width = width;
		this.height = height;
		this.color = color;
		this.borderColor = Color.BLACK;
	}
	
	public int getX1() {
		return x1;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getY1() {
		return y1;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
	
	public void changeColor(Color color) {
		this.color = color;
	}
	
	public abstract void paint(Graphics2D shape);
	
	
}
