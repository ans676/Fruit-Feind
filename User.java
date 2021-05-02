
import processing.core.*;

public class User extends PApplet{
	
	
	int size = 50; 
	float xpos = 650/2; 
	float ypos = 650/2;
	
	float sizeX =650;
	float sizeY = 650;
	
	float step = 10;
	
	PApplet canvas;
	private Object x;
	
	
	int xchange;
	int ychange;
	
	public User (PApplet canvas) {
		this.canvas = canvas;	
	}
	
	
	public void moveY(int step) {
		ychange = step;
	}
	
	public void moveX(int step) {
		xchange = step;
	}
	
	public void update() {
		ypos += ychange;
		xpos += xchange;
		
		ypos = constrain(ypos, 0, sizeY);
		xpos = constrain(xpos, 0, sizeX);
	}

		 
	
	public void show() {
		canvas.fill(155);
		
		this.canvas.circle(xpos, ypos, size);
	}}
	
	      
	
	
	
