/*import processing.core.*;



public class Maze extends PApplet{

	int xDim = 650;  
	int yDim = 650; 
	boolean game = true;
	
	User player; 

	Walls wall[] = {new Walls(this,50, 50, 50, 450), new Walls(this,50, 450, 300, 450),
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
	
	 public void keyPressed() {
		if(keyCode == UP) {
			if (checkCollision(player.xpos, player.ypos, wall, -2)) {
				System.out.print("Collision");
			}
			else {
				player.moveY(-2);
			}
			
		}
		else if (keyCode == DOWN) {
			if (checkCollision(player.xpos, player.ypos, wall, 2)) {
				System.out.print("Collision");
			}
			else {
				player.moveY(2);
			}
			
			//if (checkCollision(player.xpos, player.ypos, wall, 2)) {
			//	player.moveY(2);
			//}	
		}
		else if (keyCode == LEFT) {
			if (checkCollision(player.xpos, player.ypos, wall, 2)) {
				System.out.print("Collision");
			}
			else {
				player.moveX(-2);
			}
			//if (checkCollision(player.xpos, player.ypos, wall, 2)) {
			//	player.moveX(-2);
			//}
			//player.moveX(-2);
		}
		else if (keyCode == RIGHT) {
			if (checkCollision(player.xpos, player.ypos, wall, 2)) {
				System.out.print("Collision");
			}
			else {
				player.moveX(2);
			}
			
			
			//if (checkCollision(player.xpos, player.ypos, wall, 2)) {
			//	player.moveX(2);
			//}
			//player.moveX(2);
		}
		 
	}
	public void keyReleased( ) {
		player.moveX(0);
		player.moveY(0);
	}
	
	public boolean checkCollision(float playerX, float playerY, Walls wallList[], int step) {
		for (int i = 0; i < wallList.length; i++) {
			
			int wallX1 = wallList[i].x;
			int wallY1 = wallList[i].y;
			int wallX2 = wallList[i].x2;
			int wallY2 = wallList[i].y2;
			
			
			if (wallX1 == wallX2 ) {
				System.out.print("x's equal ");
				System.out.println("Wall" + i + " " + wallX1 + " " + wallX2 + " " + wallY1 + " " + wallY2);

				if (playerX == wallX1 + step) {
					if ( playerY + step > wallY1 || playerY + step > wallY2) {
				return true; 
				}}
			}
			else if (wallList[i].y == wallList[i].y2 ) {
				System.out.print("y's equal");
				System.out.println("Wall" + i + " " + wallX1 + " " + wallX2 + " " + wallY1 + " " + wallY2);

				if (playerY == wallY1 + step) {
					if ( playerX + step > wallX1 || playerX + step < wallY2) {
						return true; 
				}}}
		}
			
		return false;
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
	 */
	
