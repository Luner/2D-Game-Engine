package com.kulthro.games.game_engine.menu;

public interface MenuItem {

	public boolean isOn(float mouseX, float mouseY);
	public void setHoverOver(boolean teSet);
	public void setDownOn(boolean toSet);
	
	public void render();
	
	public String getAction();
	
}
