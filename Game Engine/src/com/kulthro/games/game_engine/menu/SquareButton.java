package com.kulthro.games.game_engine.menu;

import org.newdawn.slick.opengl.Texture;

public class SquareButton {
	public float leftX;
	public float bottomY;
	public float rightX;
	public float topY;
	private String key;
	private String type;
	private String action;
	private Texture tex;
	
	public SquareButton(float leftX, float bottomY, float rightX, float topY){
		this(leftX, bottomY, rightX, topY, "default", "png", "none");
	}
	
	public SquareButton(float leftX, float bottomY, float rightX, float topY, String key, String type){
		this(leftX, bottomY, rightX, topY, key, type, "none");
	}
	
	public SquareButton(float leftX, float bottomY, float rightX, float topY, String key, String type, String action){
		this.leftX = leftX;
		this.bottomY = bottomY;
		this.rightX = rightX;
		this.topY = topY;
		this.key = key;
		this.type = type;
		this.action = action;
	}
	
	public void setTexture(Texture texture){
		tex = texture;
	}
	
	public String getType(){
		return type;
	}
	
	public String getKey(){
		return key;
	}
	
	public String getAction(){
		return action;
	}
	
	public Texture getTexture(){
		return tex;
	}

	public boolean isClicked(float mouseX, float mouseY){
		if(mouseX >= leftX && mouseX <= rightX && mouseY >= bottomY && mouseY <= topY){
			return true;
		}
		return false;
	}
}
