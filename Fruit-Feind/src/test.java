import processing.core.*;

// grape invinicibility // purple square
// peach speed boost // blue square
// pac man : green square
// enemy: red square
// fodder : turquoise
// player pink : invicibile

public class test extends PApplet{

	
	Rectangle[] walls = new Rectangle[] {
		    //first 4 are border walls
		    new Rectangle(0, 0, 500, 20), new Rectangle(480, 0, 20, 500),
		    new Rectangle(0, 480, 500, 20), new Rectangle(100, 100, 50, 100),
		    new Rectangle(400, 100, 100, 50), new Rectangle(100, 400, 100, 50),
		    new Rectangle(350, 350, 50, 100), new Rectangle(250, 200, 50, 100),
		    new Rectangle(0, 0, 20, 500)};
	
	Rectangle[] wallLevelTwo = {new Rectangle(200, 100, 20, 250), 
								new Rectangle(250, 55, 100, 50), new Rectangle(75, 300, 50, 150)};
	
	Points[] points = {new Points(50,50), new Points(67,235), new Points(234,223), 
			new Points(43,500), new Points(27,345), new Points(400,50), new Points(330,420),
			new Points(440,300), new Points(290, 400), new Points(345,242),new Points(350,475),
			new Points(465,400), new Points(340,25), new Points(379,239), new Points(414,437)};
	
	
	

		
	

	Rectangle boost = new Rectangle(25, 250, 20, 20);
	Rectangle grape = new Rectangle(250, 400, 20, 20);
	Rectangle fodder = new Rectangle(400, 250, 20, 20);
	
	//Rectangle points = new Rectangle (50, 50, 5, 5);
	
	Player p = new Player(25,25,20,20);
	Player enemy = new Player(350,325,20,20);
	
	boolean boostShow = true, grapeShow = true, fodderShow =  true, gameOver = false, pointsShow = true;
	
	int level = 1, score = 0, direction;
	
	
	
	public static void main(String [] args) {
		PApplet.main("test");
	}
	
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		imageMode(CENTER);
		enemy.setSpeed(5);
		
		initializeArray(points);
	}
	
	void drawLabels() {
		fill(0);
		textSize(10); 
		if(fodderShow) text("fodder", 400, 280);
		if(grapeShow) text("invincibility", 250, 430);
		if(boostShow) text("speed boost", 25, 280);
	}
	
	//this might need to change
	void collectAll() {
		if(!gameOver) 
			gameOver = !boostShow && !grapeShow && !fodderShow;
		if(gameOver) 
			level++;
	}
	
	void collideEnemy() {
		if(collision(p, enemy) && grapeShow) {
			gameOver=true; 
			level = 100;
		}
	} 
	
	void collideGrape() {
		if(collision(p, grape)) {
			// enemy thing
			grapeShow=false;
		}
	}
	
	void collideFodder() {
		if(collision(p, fodder)) {
			fodderShow=false;
		}
	}
	
	void collideBoost() {
		if(collision(p, boost)) {
			p.setSpeed(10);
			boostShow=false;
		}
	}
	
	
	
	void drawBoost() {
		if(!boostShow) return;
		fill(0,0,255);
		rect(boost.x,boost.y,boost.w,boost.h);
	}
	
	void drawGrape() {
		if(!grapeShow) return;
		fill(255,0,255);
		rect(grape.x,grape.y,grape.w,grape.w);
	}
	
	void drawFodder() {
		if(!fodderShow) 
			return;
		fill(0,255,255);
		rect(fodder.x,fodder.y,fodder.w,fodder.h);
	}
	
	void drawScore() {
		fill(0);
		textSize(10); 
		text("level:"+(level), 440, 65);
		text("score:" + (score), 435, 75);
	}
	
	
	
	@Override
	public void draw() {
		
		background(255);
		if(!gameOver) {
			drawPlayer();
			drawEnemy();
			moveEnemy();
			drawWalls();
			drawBoost();
			drawGrape();
			drawFodder();
			collideBoost();
			collideFodder();
			collideGrape();
			collideEnemy();
			collectAll(); 
			drawScore();
			drawLabels();
			for (Points parray: points) {
				drawPoints(parray.getX(), parray.getY(), parray);
				collidePoints(parray, parray.getBoolean(), parray.pointsShow);
				

				
			}
		}
		
		else if(level <= 4){
			resetLevel();
		}
		
		else {
			fill(0);
			textSize(26); 
			if( level == 5 ) {
				text("Win", 250, 250);
			}
			else {
				text("Game Over", 250, 250);
				text("Score: " + score, 100, 100);
			}
		}
	}
	
	
	void resetLevel() {
		boostShow = true; grapeShow = true; fodderShow = true; gameOver = false;
		
		p = new Player(25,25,20,20); enemy = new Player(350,325,20,20); enemy.setSpeed(level*2+3);
		
		for (Points newPoints : points) {
			newPoints.changeBoolean(true);
		}
	}
	
	
	void moveEnemy() {
		if(frameCount%120==0) changeDirection();
		if(direction==0) {
			enemy.moveUp();
			if(collide(enemy)) {
				enemy.moveDown();
				changeDirection();
			}}
		if(direction==1) {
			enemy.moveDown();
			if(collide(enemy)) {
				enemy.moveUp();
				changeDirection();
			}}
		if(direction==2) {
			enemy.moveLeft();
			if(collide(enemy)) {
				enemy.moveRight();
				changeDirection();
			}}
		if(direction==3) {
			enemy.moveRight();
			if(collide(enemy)) {
				enemy.moveLeft();
				changeDirection();
			}}
	}
	
	void changeDirection() {
		int temp=(int)(Math.random()*4);
		while(direction==temp) temp=(int)(Math.random()*4);
		direction=temp;
	}
	
	void drawPlayer() {
		if(grapeShow) {
			fill(0,255,0);
		}
		else{
			fill(50,50,50);
		}
		rect(p.x,p.y,p.w,p.h);
	}
	
	void drawEnemy() {
		fill(255,0,0);
		rect(enemy.x, enemy.y, enemy.w, enemy.h);
	}
	
	void drawWalls() {
		fill(0);
		for(Rectangle r:walls) rect(r.x,r.y,r.w,r.h);
		if (level >= 3) {
			for(Rectangle r:wallLevelTwo) rect(r.x,r.y,r.w,r.h);
		}
	}
	
	public void drawPoints(float x, float y, Points pbool) {
		if(!pbool.getBoolean()) return;
		fill(250, 250, 0);
		rect(x, y, 5, 5);
	}
	
	public void keyPressed() {
		if(keyCode== UP) {
			p.moveUp();
			if(collide(p)) p.moveDown();
		}
		if(keyCode == DOWN) {
			p.moveDown();
			if(collide(p)) p.moveUp();
		}
		if(keyCode ==LEFT) {
			p.moveLeft();
			if(collide(p)) p.moveRight();
		}
		if(keyCode == RIGHT) {
			p.moveRight();
			if(collide(p)) p.moveLeft();
		}
	}
	
	boolean overlap(float start1, float end1, float start2, float end2) {
		return end2>=start1 && start2<=end1;
	}
	
	boolean collision(Rectangle r1, Rectangle r2) {
		return overlap(r1.getX(),r1.getX()+r1.getW(),r2.getX(),r2.getX()+r2.getW())
				&& overlap(r1.getY(),r1.getY()+r1.getH(),r2.getY(),r2.getY()+r2.getH());
	}
	
	boolean collide(Player p) {
		for(Rectangle r:walls) if(collision(r,p)) return true;
		return false;
	}
	
	void collidePoints(Points point, boolean show, boolean change) {
		if(collision(p, point) && show == true) {
			score++; 
			point.changeBoolean(false);
		}
	}
	
	void initializeArray (Points [] points) {
		for (Points newPoints : points) {
			newPoints = new Points((float)Math.random()*500, (float)Math.random()*500);
		}
	}
}
