package dev.nynjaorca.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.nynjaorca.tilegame.Game;
import dev.nynjaorca.tilegame.Handler;
import dev.nynjaorca.tilegame.gfx.Assets;
import dev.nynjaorca.tilegame.ui.ClickListener;
import dev.nynjaorca.tilegame.ui.UIImageButton;
import dev.nynjaorca.tilegame.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(720, 405, 512, 128, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {	
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		}

}
