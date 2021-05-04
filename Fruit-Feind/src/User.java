
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
	
	/*public void constrainVariables(float leftX, float rightX, float topY, float bottomY) {		
		xpos = constrain(xpos, 0, leftX);
		xpos = constrain(xpos, rightX, sizeX);
		ypos = constrain(ypos, 0, bottomY);
		ypos = constrain(ypos, topY, sizeY);
		
		//player.constrainVariables(wall[i].x, wall[i].x + wall[i].width, wall[i].y, wall[i].y + wall[i].height);
	}*/
		 
	
	public void show() {
		canvas.fill(155);
		
		this.canvas.circle(xpos, ypos, size);
	}
	
// currently from processing forum 
	/*public boolean checkBoundaryCollision(float cx, float cy, float radius, float rx, float ry, float rw, float rh) {
		// temporary variables to set edges for testing
		  float testX = cx;
		  float testY = cy;

		  // which edge is closest?
		  if (cx < rx)         testX = rx;      // test left edge
		  else if (cx > rx+rw) testX = rx+rw;   // right edge
		  if (cy < ry)         testY = ry;      // top edge
		  else if (cy > ry+rh) testY = ry+rh;   // bottom edge

		  // get distance from closest edges
		  float distX = cx-testX;
		  float distY = cy-testY;
		  float distance = sqrt( (distX*distX) + (distY*distY) );

		  // if the distance is less than the radius, collision!
		  if (distance <= radius) {
		    return true;
		  }
		  return false;
		
	  }*/


}
	
	      
	
	
	
