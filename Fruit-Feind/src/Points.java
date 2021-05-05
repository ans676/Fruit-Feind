import processing.core.*;


public class Points extends Rectangle {
	
	boolean pointsShow = true;
	//float x, y;


	Points(float a, float b) {
		super(a,b,5,5);
	}
	
	public boolean getBoolean() {
		return pointsShow;
	}
	public void changeBoolean (boolean changed) {
		pointsShow = changed;
	}
	
	
}
