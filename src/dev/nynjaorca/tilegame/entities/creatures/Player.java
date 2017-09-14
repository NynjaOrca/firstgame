package dev.nynjaorca.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.nynjaorca.tilegame.Game;
import dev.nynjaorca.tilegame.Handler;
import dev.nynjaorca.tilegame.gfx.Animation;
import dev.nynjaorca.tilegame.gfx.Assets;

public class Player extends Creature{
	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10.0f;
	
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 18;
		bounds.y = 24;
		bounds.width = 32;
		bounds.height = 36;
//		xMove = 0;
//		yMove = 0;
		
		
		//animations
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(100, Assets.player_left);
		animRight = new Animation(100, Assets.player_right);
	}

	@Override
	public void tick() {
		xMove = 0;
		
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);

	}
	
	private void getInput() {
		
		//gravity
		if(falling || jumping) {
			y += yMove;
			yMove += gravity;
			if(yMove > MAX_SPEED) {
				yMove = MAX_SPEED;
			}
		}
		
//		if(handler.getKeyManager().up)
//			yMove = -speed;
//		if(handler.getKeyManager().down)
//			yMove = speed * 2;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().jump)
			yMove = -speed;
	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
									(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
					(int) (y + bounds.y - handler.getGameCamera().getyOffset()) , bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}else if(yMove < 0) {
			return animUp.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
		}
		
	}

}
