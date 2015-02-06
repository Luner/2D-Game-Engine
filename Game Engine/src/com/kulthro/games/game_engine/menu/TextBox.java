package com.kulthro.games.game_engine.menu;

import org.newdawn.slick.Color;

import com.kulthro.games.game_engine.Screen;
import com.kulthro.games.game_engine.Sounds;

public class TextBox implements MenuItem{
	private float leftX;
	private float topY;
	private boolean hoverOver = false;
	private boolean downOn = false;
	private boolean newAction = true;
	//private float rightX;  To be implemented, bounds
	//private float bottomY;  To be implemented, bounds
	private String action;
	private String text;
	private Color color;
	
	public TextBox(float leftX, float topY){
		this(leftX, topY, "Default");
	}
	
	public TextBox(float leftX, float topY, String text){
		this(leftX, topY, text, Color.black, "");
	}
	
	public TextBox(float topY, String text) {
		this((Screen.WIDTH/2) - (Screen.fontSize*text.length())/2, topY, text, Color.black, "");
	}
	
	public TextBox(float topY, String text, Color color) {
		this((Screen.WIDTH/2) - (Screen.font.getWidth(text))/2, topY, text, color, "");
	}
	
	public TextBox(float topY, String text, Color color, String action) {
		this((Screen.WIDTH/2) - (Screen.font.getWidth(text))/2, topY, text, color, action);
	}
	
	public TextBox(float leftX, float topY, String text, Color color, String action){
		this.leftX = leftX;
		this.topY = topY;
		this.text = text;
		this.color = color;
		this.action = action;
	}
	
	public boolean isOn(float mouseX, float mouseY){
		if(mouseX >= leftX && mouseX <= leftX + Screen.font.getWidth(text) && mouseY >= topY && mouseY <= topY + Screen.font.getHeight(text)){
			return true;
		}
		return false;
	}
	
	public void isNewAction(){
		newAction = true;
	}
	
	public void setDownOn(boolean downOn){
		this.downOn = downOn;
	}

	public void setHoverOver(boolean hoverOver){
		this.hoverOver = hoverOver;
	}
	
	public void render(){
		if(downOn){
			color = Color.darkGray;
			this.downOn = false;
			newAction = false;
		} else {
			if(hoverOver){
				if(newAction){
					Sounds.BUTTON.playAsSoundEffect(1.0f, 1.0f, false);
					color = Color.lightGray;
					newAction = false;
				}
			} else {
				color = Color.white;
				newAction = true;
			}
		}
		renderText();
	}
	
	public void renderText(){
		Screen.font.drawString(leftX, topY, text, color);	
	}


	public String getAction() {
		return action;
	}
}
