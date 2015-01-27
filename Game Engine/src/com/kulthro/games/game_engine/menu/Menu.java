package com.kulthro.games.game_engine.menu;

import com.kulthro.games.game_engine.Render;

public class Menu { 

	private boolean initialized = false;
	private SquareButton buttons[];
	public static int index = 0;
	
	public Menu(SquareButton[] buttons){
		this.buttons = buttons;
	}

	public void unInitialize(){
		this.initialized = false;
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
			buttons[i].setTexture(Render.getTexture(buttons[i].getKey(), buttons[i].getType()));
		}
	}

	public void renderButtons(){
		for (int i = 0; i < buttons.length; i++){
			buttons[i].render();
		}
	}

	public String click(int Mousex, int Mousey){
		for (int i = 0; i < buttons.length; i++){
			if (buttons[i].isClicked(Mousex, Mousey)){
				return buttons[i].getAction();
			}
		}
		return "";
	}
}
