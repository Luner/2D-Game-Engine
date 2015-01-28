package com.kulthro.games.game_engine.menu;

import org.newdawn.slick.opengl.Texture;

import com.kulthro.games.game_engine.Render;

public class SquareButton {
	private float leftX;
	private float topY;
	private float rightX;
	private float bottomY;
	private boolean downOn = false;
	private String key;
	private String type;
	private String action;
	private Texture tex;
	
	public SquareButton(float leftX, float topY, float rightX, float bottomY){
		this(leftX, topY, rightX, bottomY, "default", "png", "none");
	}
	
	public SquareButton(float leftX, float topY, float rightX, float bottomY, String key, String type){
		this(leftX, topY, rightX, bottomY, key, type, "none");
	}
	
	public SquareButton(float leftX, float topY, float rightX, float bottomY, String key, String type, String action){
		this.leftX = leftX;
		this.topY = topY;
		this.rightX = rightX;
		this.bottomY = bottomY;
		this.key = key;
		this.type = type;
		this.action = action;
	}
	
	public void setDownOn(boolean downOn){
		this.downOn = downOn;
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
	
	public void render(){
		if(downOn == false){
			renderNormal();
		} else {
			renderDark();
		}
	}
	
	public void renderNormal(){
		Render.renderQuad(this.leftX, this.topY, this.rightX, this.bottomY, this.tex);
	}
	
	public void renderDark(){
		Render.renderQuad(this.leftX, this.topY, this.rightX, this.bottomY, this.tex, 0.7f, 0.7f, 0.7f);
	}
	
	public boolean isOn(float mouseX, float mouseY){
		if(mouseX >= leftX && mouseX <= rightX && mouseY >= topY && mouseY <= bottomY){
			return true;
		}
		return false;
	}
}
