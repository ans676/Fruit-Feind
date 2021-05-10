
public class Player extends Rectangle{
	
	float speed = 10F;
	
	Player(float a, float b, float c, float d) {
		super(a, b, c, d);
	}
	
	void moveUp() {y-=speed;}
	void moveDown() {y+=speed;}
	void moveRight() {x+=speed;}
	void moveLeft() {x-=speed;}
	void setSpeed(float s) {speed=s;}
}
