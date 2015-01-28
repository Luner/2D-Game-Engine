package com.kulthro.games.game_engine.menu;

import org.newdawn.slick.Color;

import com.kulthro.games.game_engine.Game;
import com.kulthro.games.game_engine.Screen;

public class TextBox {
	private float leftX;
	private float topY;
	//private float rightX;  To be implemented, bounds
	//private float bottomY;  To be implemented, bounds
	private String text;
	private Color color;
	
	public TextBox(float leftX, float topY){
		this(leftX, topY, "Default");
	}
	
	public TextBox(float leftX, float topY, String text){
		this(leftX, topY, text, Color.black);
	}
	
	public TextBox(float topY, String text) {
		this((Game.WIDTH/2) - (Screen.fontSize*text.length())/2, topY, text, Color.black);
	}
	
	public TextBox(float topY, String text, Color color) {
		this((Game.WIDTH/2) - (Screen.font.getWidth(text))/2, topY, text, color);
	}
	
	public TextBox(float leftX, float topY, String text, Color color){
		this.leftX = leftX;
		this.topY = topY;
		this.text = text;
		this.color = color;
	}
	
	public void render(){
		Screen.font.drawString(leftX, topY, text, color);	
	}
}
