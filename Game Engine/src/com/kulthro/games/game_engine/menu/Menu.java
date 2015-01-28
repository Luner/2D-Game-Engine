package com.kulthro.games.game_engine.menu;

import com.kulthro.games.game_engine.Render;
import com.kulthro.games.game_engine.util.Vector2f;

public class Menu { 

	private boolean initialized = false;
	private MenuItem items[];
	public static int index = 0;

	public Menu(MenuItem[] items){
		this.items = items;
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

	public void update(Vector2f mousePosition){

		for(MenuItem item : items){	
			if(item.isOn(mousePosition.getX(), mousePosition.getY())){
				item.setHoverOver(true);
			} else {
				item.setHoverOver(false);
			}
		}
		
		renderItems();
	}

	public void loadButtonTextures(){
		for(MenuItem item : items){
			if(item instanceof SquareButton)
			((SquareButton)item).setTexture(Render.getTexture(((SquareButton)item).getKey(), ((SquareButton)item).getType()));
		}
	}

	public void renderItems(){
		for (MenuItem item : items){
			item.render();
		}
	}

	public String click(Vector2f position){
		for (MenuItem item : items){
			if (item.isOn(position.getX(), position.getY())){
				return item.getAction();
			}
		}
		return "";
	}

	public void mouseDown(Vector2f position) {
		for (MenuItem item : items){
			if (item.isOn(position.getX(), position.getY())){
				item.setDownOn(true);
			} else {
				item.setDownOn(false);
			}
		}
	}
}
