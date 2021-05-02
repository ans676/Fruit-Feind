import processing.core.*;



public class Maze extends PApplet{

	int xDim = 650;  
	int yDim = 650; 
	boolean game = true;
	
	User player; 

	
	
	public static void main(String[] args) {
		PApplet.main("Maze");
		
	
	}
	
	
	
			
	// method used only for setting the size 
	public void settings() {
		size(xDim,yDim);
	}
	
	public void setup() {
		background(200);
		player = new User(this);
	}
	
	public void keyPressed() {
		if(keyCode == UP) {
			player.moveY(-10);
			
		}
		else if (keyCode == DOWN) {
			player.moveY(10);
		}
		else if (keyCode == LEFT) {
			player.moveX(-10);
		}
		else if (keyCode == RIGHT) {
			player.moveX(10);
		}
		
	}
	public void keyReleased( ) {
		player.moveX(0);
		player.moveY(0);
	}
	
	
	public void draw() {
		fill(100);
		stroke(100);
		rect(50, 50, 100, 150); 
		rect(400, 100, 100, 150);
		rect(50, 350, 100, 150);
		rect(400, 450, 100, 150);
		rect(250, 50, 50, 250);
		rect(50, 250, 250, 50);
	 	rect(300, 350, 50, 250);
	 	rect(350, 350, 250, 50);
	 	rect(50, 550, 250, 50);
	 	rect(550, 50, 50, 300);
	 	
	 	player.show(); 
	 	player.update();
	 	
	 	
	 	
	 		}
	}
	 
	
