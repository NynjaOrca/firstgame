package dev.nynjaorca.tilegame;

import dev.nynjaorca.tilegame.Game;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("title", 1440, 810);
		game.start();
	}
	
}
