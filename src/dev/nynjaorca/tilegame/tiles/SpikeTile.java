package dev.nynjaorca.tilegame.tiles;

import dev.nynjaorca.tilegame.gfx.Assets;

public class SpikeTile extends Tile{

	public SpikeTile(int id) {
		super(Assets.spike, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
	
}
