package com.kulthro.games.game_engine.menu;

import org.newdawn.slick.Color;

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
