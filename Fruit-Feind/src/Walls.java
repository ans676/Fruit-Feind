import processing.core.*;

public class Walls extends PApplet{

	PApplet canvas;
	int x;
	int y;
	int width;
	int height;

	public Walls (PApplet canvas, int x, int y, int width, int height) {
		this.canvas = canvas;	
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void update() {
		
	}

	public void show() {
		this.canvas.rect(x, y, width, height);
	}}
	
	      
	
	
	
