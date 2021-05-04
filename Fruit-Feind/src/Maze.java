import processing.core.*;



public class Maze extends PApplet{

	int xDim = 650;  
	int yDim = 650; 
	boolean game = true;
	
	User player; 

	Walls [] wall = {new Walls(this,50, 50, 50, 450), new Walls(this,50, 450, 300, 450),
			new Walls(this,300, 450, 300, 550), new Walls(this,300, 550, 50, 550), new Walls(this,150, 50, 250, 50), 
			new Walls(this, 250, 50, 250, 150), new Walls(this,250, 150, 550, 150), new Walls(this,550, 150, 550, 450), 
			new Walls(this, 450, 550, 450, 250), new Walls(this,450, 250, 150, 250)};
	
	
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
	public boolean collision() {
		if (player.xpos == )
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
			strokeWeight(10);
			//fill(10 + i*10);
			wall[i].show();
		}
		
		fill(100);
		stroke(100);
		
	 	player.show(); 
	 	player.update();
	 	
	 	}
	}
	 
	
