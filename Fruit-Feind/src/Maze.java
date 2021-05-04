import processing.core.*;



public class Maze extends PApplet{

	int xDim = 650;  
	int yDim = 650; 
	boolean game = true;
	
	User player; 

	Walls [] wall = {new Walls(this,50, 50, 100, 150), new Walls(this,400, 100, 100, 150),
			new Walls(this,50, 350, 100, 150), new Walls(this,400, 450, 100, 150), new Walls(this,50, 50, 50, 250), 
			new Walls(this, 50, 250, 250, 50), new Walls(this,300, 350, 50, 250), new Walls(this,350, 350, 250, 50), 
			new Walls(this,50, 550, 250, 50), new Walls(this,550, 50, 50, 300)};
	/*
	Walls first = new Walls(this,50, 50, 100, 150);
	Walls second = new Walls(this,400, 100, 100, 150);
	Walls third = new Walls(this,50, 350, 100, 150);
	Walls fourth = new Walls(this,400, 450, 100, 150);
	Walls fifth = new Walls(this,50, 50, 50, 250);
	Walls sixth = new Walls(this, 50, 250, 250, 50);
	Walls seventh = new Walls(this,300, 350, 50, 250);
	Walls eight = new Walls(this,350, 350, 250, 50);
	Walls ninth = new Walls(this,50, 550, 250, 50);
	Walls tenth = new Walls(this,550, 50, 50, 300);
	*/ 
	
	
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
		for (int i = 0; i < wall.length; i++) {
			fill(10 + i*10);
			wall[i].show();
		}
		
		fill(100);
		stroke(100);
		
	 	player.show(); 
	 	player.update();
	 	
	 	}
	}
	 
	
