import java.awt.Color;
import java.awt.Graphics2D;

//subclass that extends Shape, allowing use of its getter/setter methods.
//Implements the paint method used when the color of each cubelet is set and/or changed
public class Rectangle extends Shape {
	
	//default constructor
	public Rectangle() {
		
	}
	
	public Rectangle(int x1, int y1, int width, int height, Color color) {
		super(x1, y1, width, height, color);
	}
	
	@Override
	public void paint(Graphics2D shape) {
		shape.setColor(getColor());
		shape.fillRect(getX1(), getY1(), getWidth(), getHeight());
		Color temp = shape.getColor();
		shape.setColor(getBorderColor());
		shape.drawRect(getX1(), getY1(), getWidth(), getHeight());
		shape.setColor(temp);
	}
}
