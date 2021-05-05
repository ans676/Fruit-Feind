import processing.core.*;

public class Rectangle extends PApplet{
	
	float x,y,w,h;
	
	Rectangle(float a, float b, float c, float d){
		x = a; 
		y = b; 
		w = c; 
		h = d;
	}
	
	float getX() {return x;}
	float getY() {return y;}
	float getW() {return w;}
	float getH() {return h;}
}