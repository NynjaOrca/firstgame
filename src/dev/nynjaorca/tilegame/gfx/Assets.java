package dev.nynjaorca.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	//private static final int width = ??, height = ??
	
	public static BufferedImage grass, spike, icicle;
	public static BufferedImage[] player_down, player_left, player_right, player_up;
	public static BufferedImage[] penguin_down, penguin_up, penguin_left, penguin,right;
	public static BufferedImage[] btn_start;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/fireball.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/terrain.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/Icicle.png"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/buttons.png"));
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet4.crop(0, 0, 256, 64);
		btn_start[1] = sheet4.crop(0, 64, 256, 64);
		
		player_down = new BufferedImage[4];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		player_up = new BufferedImage[4];
		
		player_down[0] = sheet.crop(0, 0, 64, 64);
		player_down[1] = sheet.crop(64, 0, 64, 64);
		player_down[2] = sheet.crop(128, 0, 64, 64);
		player_down[3] = sheet.crop(192, 0, 64, 64);
		
		player_up[0] = sheet.crop(0, 192, 64, 64);
		player_up[1] = sheet.crop(64, 192, 64, 64);
		player_up[2] = sheet.crop(128, 192, 64, 64);
		player_up[3] = sheet.crop(192, 192, 64, 64);
		
		player_left[0] = sheet.crop(0, 128, 64, 64);
		player_left[1] = sheet.crop(64, 128, 64, 64);
		player_left[2] = sheet.crop(128, 128, 64, 64);

		player_right[0] = sheet.crop(0, 64, 64, 64);
		player_right[1] = sheet.crop(64, 64, 64, 64);
		player_right[2] = sheet.crop(128, 64, 64, 64);
		
		
		
		grass = sheet2.crop(0, 32, 32, 32);
		spike = sheet2.crop(32, 32, 32, 32);
		icicle = sheet3.crop(0, 0, 64, 128);
	}
	
}
