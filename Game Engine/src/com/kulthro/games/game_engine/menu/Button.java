package com.kulthro.games.game_engine.menu;

import org.newdawn.slick.opengl.Texture;

public class Button {
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	private String key;
	private Texture tex;
	
	public Button(int x1, int y1, int x2, int y2, String key){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.key = key;
	}
	
	public void setTexture(Texture texture){
		tex = texture;
	}
	
	public String getKey(){
		return key;
	}
	
	public Texture getTexture(){
		return tex;
	}

	public boolean isClicked(int Mousex, int Mousey){
		if(Mousex >= x1 && Mousex <= x2 && Mousey >= y1 && Mousey <= y2){
			return true;
		}
		return false;
	}
}
