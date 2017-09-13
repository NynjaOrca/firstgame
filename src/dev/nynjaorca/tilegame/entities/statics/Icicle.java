package dev.nynjaorca.tilegame.entities.statics;

import java.awt.Graphics;

import dev.nynjaorca.tilegame.Handler;
import dev.nynjaorca.tilegame.gfx.Assets;
import dev.nynjaorca.tilegame.tiles.Tile;

public class Icicle extends StaticEntity{

	public Icicle(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width -20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.icicle, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
