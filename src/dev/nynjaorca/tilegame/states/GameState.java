package dev.nynjaorca.tilegame.states;

import java.awt.Graphics;

import dev.nynjaorca.tilegame.Game;
import dev.nynjaorca.tilegame.Handler;
import dev.nynjaorca.tilegame.entities.creatures.Player;
import dev.nynjaorca.tilegame.entities.statics.Icicle;
import dev.nynjaorca.tilegame.gfx.Assets;
import dev.nynjaorca.tilegame.tiles.Tile;
import dev.nynjaorca.tilegame.worlds.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
}
