package com.kulthro.games.game_engine.menu;

import org.newdawn.slick.opengl.Texture;

import com.kulthro.games.game_engine.Render;
import com.kulthro.games.game_engine.Sounds;
import com.kulthro.games.game_engine.util.Shade;

public class SquareButton implements MenuItem {
	
	private float leftX, topY, rightX, bottomY;
	
	private boolean hoverOver = false, downOn = true, newAction = true;	
	
	private String key, type, action;
	
	private Shade shade;
	private Texture tex;

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
		this.shade = new Shade(1.0f);
	}

	public void render(){
		setShade();
		renderButton();
	}
	
	private void setShade(){
		if(downOn){
			shade.setIntensity(0.4f);
			this.downOn = false;
			newAction = false;
		} else {
			if(hoverOver){
				if(newAction){
					Sounds.BUTTON.playAsSoundEffect(1.0f, 1.0f, false);
					shade.setIntensity(0.7f);
					newAction = false;
				}
			} else {
				shade.setIntensity(1.0f);
				newAction = true;
			}
		}
	}

	private void renderButton(){
		Render.renderShadedQuad(this.leftX, this.topY, this.rightX, this.bottomY, this.tex, shade.getIntensity());
	}
	
	public boolean isOn(float mouseX, float mouseY){
		if(mouseX >= leftX && mouseX <= rightX && mouseY >= topY && mouseY <= bottomY){
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
}
