package com.kulthro.games.game_engine.menu;

import com.kulthro.games.game_engine.Render;
import com.kulthro.games.game_engine.util.Vector2f;

public class Menu { 

	private boolean initialized = false;
	private SquareButton buttons[];
	private TextBox textBoxes[];
	public static int index = 0;

	public Menu(SquareButton[] buttons){
		this(buttons, new TextBox[] {});
	}

	public Menu(TextBox[] textBoxes){
		this(new SquareButton[] {}, textBoxes);
	}

	public Menu(SquareButton[] buttons, TextBox[] textBoxes){
		this.buttons = buttons;
		this.textBoxes = textBoxes;
	}

	public void unInitialize(){
		this.initialized = false;
	}

	public boolean isInitialized(){
		return initialized;
	}

	public void initMenu(){
		loadButtonTextures();
		initialized = true;
	}

	public void update(Vector2f mousePosition){

		for(SquareButton button : buttons){	
			if(button.isOn(mousePosition.getX(), mousePosition.getY())){
				button.setHoverOver(true);
			} else {
				button.setHoverOver(false);
			}
		}

		renderButtons();
		renderTextBoxes();
	}

	public void loadButtonTextures(){
		for(int i = 0; i < buttons.length; i++){
			buttons[i].setTexture(Render.getTexture(buttons[i].getKey(), buttons[i].getType()));
		}
	}

	public void renderTextBoxes(){
		for (TextBox textBox : textBoxes){
			textBox.render();
		}
	}

	public void renderButtons(){
		for (SquareButton button : buttons){
			button.render();
		}
	}

	public String click(Vector2f position){
		for (int i = 0; i < buttons.length; i++){
			if (buttons[i].isOn(position.getX(), position.getY())){
				return buttons[i].getAction();
			}
		}
		return "";
	}

	public void mouseDown(Vector2f position) {
		for (int i = 0; i < buttons.length; i++){
			if (buttons[i].isOn(position.getX(), position.getY())){
				buttons[i].setDownOn(true);
			} else {
				buttons[i].setDownOn(false);
			}
		}
	}
}
