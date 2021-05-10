import processing.core.*;
// grape invinicibility // purple square
// peach speed boost // blue square
// pac man : green square
// enemy: red square
// cherry : turquoise
// player pink : invicibile
public class test extends PApplet{
	public static void main(String []args) {
		PApplet.main("test");
	}
	Rectangle[] walls = new Rectangle[] {
		    //first 4 are border walls
		    new Rectangle(0, 0, 500, 20),
		    new Rectangle(480, 0, 20, 500),
		    new Rectangle(0, 480, 500, 20),
		    new Rectangle(100, 100, 50, 100),
		    new Rectangle(400, 100, 100, 50),
		    new Rectangle(100, 400, 100, 50),
		    new Rectangle(350, 350, 50, 100),
		    new Rectangle(250, 200, 50, 100),
		    new Rectangle(0, 0, 20, 500)
		};
	Rectangle boost=new Rectangle(25, 250, 20, 20);
	Rectangle grape=new Rectangle(250, 400, 20, 20);
	Rectangle cherry=new Rectangle(400, 250, 20, 20);
	Player p=new Player(25,25,20,20);
	Player e=new Player(350,325,20,20);
	boolean boostShow=true, grapeShow=true, cherryShow=true, gameOver=false;
	int level=0, direction;
	public void settings() {
		size(500,500);
	}
	@Override
	public void setup() {
		
		imageMode(CENTER);
		e.setSpeed(5);
	}
	void drawLabels() {
		fill(0);
		textSize(10); 
		if(cherryShow) text("cherry", 400, 280);
		if(grapeShow) text("invicibility", 250, 430);
		if(boostShow) text("speed boost", 25, 280);
	}
	void collectAll() {
		if(!gameOver) gameOver=!boostShow&&!grapeShow&&!cherryShow;
		if(gameOver) level++;
	}
	void collideEnemy() {
		if(collision(p, e)&&grapeShow) {
			gameOver=true; level=100;
		}
	}
	void collideGrape() {
		if(collision(p, grape)) {
			// enemy thing
			grapeShow=false;
		}
	}
	void collideCherry() {
		if(collision(p, cherry)) {
			cherryShow=false;
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
	void drawCherry() {
		if(!CherryShow) return;
		fill(0,255,255);
		rect(cherry.x,cherry.y,cherry.w,cherry.h);
	}
	void drawScore() {
		fill(0);
		textSize(10); 
		text("level:"+(level+1), 440, 65);
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
			drawCherry();
			collideBoost();
			collideCherry();
			collideGrape();
			collideEnemy();
			collectAll(); 
			drawScore();
			drawLabels();
		}
		else if(level<3){
			resetLevel();
		}
		else {
			fill(0);
			textSize(26); 
			if(level==3) {
				text("Win", 250, 250);
			}
			else {
				text("Game Over", 250, 250);
			}
		}
	}
	void resetLevel() {
		boostShow=true; grapeShow=true; cherryShow=true; gameOver=false;
		p=new Player(25,25,20,20); e=new Player(350,325,20,20); e.setSpeed(level*2+5); 
	}
	void moveEnemy() {
		if(frameCount%120==0) changeDirection();
		if(direction==0) {
			e.moveUp();
			if(collide(e)) {
				e.moveDown();
				changeDirection();
			}
		}
		if(direction==1) {
			e.moveDown();
			if(collide(e)) {
				e.moveUp();
				changeDirection();
			}
		}
		if(direction==2) {
			e.moveLeft();
			if(collide(e)) {
				e.moveRight();
				changeDirection();
			}
		}
		if(direction==3) {
			e.moveRight();
			if(collide(e)) {
				e.moveLeft();
				changeDirection();
			}
		}
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
		rect(e.x,e.y,e.w,e.h);
	}
	void drawWalls() {
		fill(0);
		for(Rectangle r:walls) rect(r.x,r.y,r.w,r.h);
	}
	@Override
	public void keyPressed() {
		if(key=='w') {
			p.moveUp();
			if(collide(p)) p.moveDown();
		}
		if(key=='s') {
			p.moveDown();
			if(collide(p)) p.moveUp();
		}
		if(key=='a') {
			p.moveLeft();
			if(collide(p)) p.moveRight();
		}
		if(key=='d') {
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
}


