package com.kulthro.games.game_engine.menu;

public interface MenuItem {
	public String getAction();
	public void render();
	public boolean isOn(float mouseX, float mouseY);
	public void setHoverOver(boolean teSet);
	public void setDownOn(boolean toSet);
}
