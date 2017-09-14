package dev.nynjaorca.tilegame.entities.creatures;

import dev.nynjaorca.tilegame.Game;
import dev.nynjaorca.tilegame.Handler;
import dev.nynjaorca.tilegame.entities.Entity;
import dev.nynjaorca.tilegame.tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 4.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	protected boolean falling = true;
	protected boolean jumping = false;

	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
//	public boolean falling() {
//		int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
//		
//		if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
//				(!collisionWithTile((int) (x + bounds.x + bounds.width / Tile.TILEWIDTH), ty))){
//			y += gravity;
//			return falling = true;
//		}else {
//			y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
//			return falling = false;
//		}
//	}
	
	public void moveX() {
		if(xMove > 0) {//MOVING RIGHT
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y + 20) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else {
//				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width;
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width;
			}
			
		}else if(xMove < 0) {//MOVING LEFT
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + (bounds.y - 20)) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH;
			}
		}
	}

	public void moveY() {
		if(yMove < 0) {//UP
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x - 30) / Tile.TILEWIDTH, ty) &&
					(!collisionWithTile((int) (x + bounds.x + bounds.width / Tile.TILEWIDTH), ty))){
				y += yMove;
				falling = true;
			}else {
				falling = true;
				jumping = false;
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y + 2;
			}
					
		}else if(yMove > 0) {//DOWN
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					(!collisionWithTile((int) (x + bounds.x + bounds.width / Tile.TILEWIDTH), ty))){
				falling = true;
			}else {
				falling = false;
				jumping = false;
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 2;
			}
		}
	}
	
		
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	//GETTERS AND SETTERS
	
	public float getxMove() {
		return xMove;
	}



	public void setxMove(float xMove) {
		this.xMove = xMove;
	}



	public float getyMove() {
		return yMove;
	}



	public void setyMove(float yMove) {
		this.yMove = yMove;
	}



	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	
	
}
