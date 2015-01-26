package com.kulthro.games.game_engine.menu;

import com.kulthro.games.game_engine.Render;
import com.kulthro.games.game_engine.files.ImageReader;

public class Menu { 

	private boolean initialized = false;
	private SquareButton buttons[];
	ImageReader load = new ImageReader();

	public Menu(SquareButton[] buttons){
		this.buttons = buttons;
	}

	public boolean isInitialized(){
		return initialized;
	}

	public void initMenu(){
		loadButtonTextures();
		initialized = true;
	}

	public void update(){
		renderButtons();
	}

	public void loadButtonTextures(){
		for(int i = 0; i < buttons.length; i++){
			buttons[i].setTexture(load.loadTexture(buttons[i].getKey(), buttons[i].getType()));
		}
	}

	public void renderButtons(){
		for (int i = 0; i < buttons.length; i++){
			renderButton(buttons[i]);
		}
	}

	public String click(int Mousex, int Mousey){
		for (int i = 0; i < buttons.length; i++){
			if (buttons[i].isClicked(Mousex, Mousey)){
				return buttons[i].getKey();
			}
		}
		return "";
	}

	private void renderButton(SquareButton button){
		Render.renderQuad(button.leftX, button.bottomY, button.rightX, button.topY, button.getTexture());
	}
}
