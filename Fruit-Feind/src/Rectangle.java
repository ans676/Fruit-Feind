import processing.core.*;

public class Rectangle extends PApplet{
	
	float x,y,width,height;
	
	Rectangle(float a, float b, float c, float d){
		x = a; 
		y = b; 
		width = c; 
		height = d;
	}
	
	float getX() {return x;}
	float getY() {return y;}
	float getW() {return width;}
	float getH() {return height;}
}