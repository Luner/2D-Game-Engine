package com.kulthro.games.game_engine.menu;

import com.kulthro.games.game_engine.files.ImageReader;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL11;

public class Menu { 

	private boolean initialized = false;
	private SquareButton buttons[];
	ImageReader load = new ImageReader();

	public Menu(SquareButton[] buttons){
		this.buttons = buttons;
	}

	public boolean isInitialized(){
		return initialized;
	}

	public void initMenu(){
		loadButtonTextures();
		initialized = true;
	}

	public void update(){
		renderButtons();
	}

	public void loadButtonTextures(){
		for(int i = 0; i < buttons.length; i++){
			buttons[i].setTexture(load.loadTexture(buttons[i].getKey(), buttons[i].getType()));
		}
	}

	public void renderButtons(){
		for (int i = 0; i < buttons.length; i++){
			renderButton(buttons[i]);
		}
	}

	public String click(int Mousex, int Mousey){
		for (int i = 0; i < buttons.length; i++){
			if (buttons[i].isClicked(Mousex, Mousey)){
				return buttons[i].getKey();
			}
		}
		return "";
	}

	private void renderButton(SquareButton button){
		
		button.getTexture().bind();
		glBegin(GL_QUADS);
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		GL11.glTexCoord2f(0.0f,1.0f);
		GL11.glVertex2f(button.leftX, button.bottomY);        	// Bottom Left Of The Quad
		GL11.glTexCoord2f(1.0f,1.0f);
		GL11.glVertex2f(button.rightX, button.bottomY);   	// Bottom Right Of The Quad 
		GL11.glTexCoord2f(1.0f,0.0f);
		GL11.glVertex2f(button.rightX, button.topY);	// Top Right Of The Quad 
		GL11.glTexCoord2f(0.0f,0.0f);
		GL11.glVertex2f(button.leftX, button.topY);  		// Top Left Of The Quad 
		glEnd();
		glBindTexture(GL_TEXTURE_2D, 0);
	}
}
