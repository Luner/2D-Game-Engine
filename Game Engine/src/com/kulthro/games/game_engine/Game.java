package com.kulthro.games.game_engine;

import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import com.kulthro.games.game_engine.*;
import com.kulthro.games.game_engine.camera.*;
import com.kulthro.games.game_engine.entities.*;
import com.kulthro.games.game_engine.menu.*;

public class Game {

	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	public final static int FRAME_RATE = 60;
	public final static String TITLE = "Kulthro";

	private State state = State.MainMenu;
	
	private Menu mainMenu = new Menu(new SquareButton[] {
			new SquareButton(200,400,600,500, "Start", "png"),
			new SquareButton(200,250,600,350, "Options", "png"),
			new SquareButton(200,100,600,200, "Exit", "png")
	});
	
	private ArrayList<Entity> entities;

	public Game() {
		entities = new ArrayList<Entity>();
		//Test Adding players
		entities.add(new Player(100,400));
		entities.add(new Player(310,200));
		entities.add(new Player(700,40));

		Screen.initDisplay(this);
		Screen.initGL();
		this.run();
		Screen.closeDisplay();

	}

	public static void main(String[] args) {
		Game game = new Game();
	}
	/*------------------------------------------------- 
	/  Game Logic functions
	/-------------------------------------------------- 
	/
	/ One tick is equal to one frame. Rather than edit the while loop in run(), please add all tick methods within tick();
	*/
	
	private void run() {

		while(Screen.screenIsOpen()) {
			
			Screen.clearScreen();
			
			switch(state) {
			case MainMenu:

				//initializes the menu
				if(mainMenu.isInitialized() == false){
					mainMenu.initMenu();
				}
				//Returns the name of the button if it is clicked
				if(Mouse.isButtonDown(0)){
					String key = mainMenu.click(Mouse.getX(), Mouse.getY());
					if(key != ""){
						System.out.println(key);
						if(key.equals("Exit")){
							Screen.closeDisplay();
						}
						else if(key.equals("Start")){
							state = State.Game;
						}
					}
				}
				mainMenu.update();
				break;

			case Game:
				/*Game Stuff Here*/
				tick();
				Screen.drawGame();
				break;
			}
			Screen.updateScreen();

		}
	}
	
	public void tick() {
		//Update all Entities
		for(Entity e : entities) {
			e.update();
		}
	}
	
	//-------------------------------------------------- 
	//  Getters and Setters
	//-------------------------------------------------- 
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public int getEntityCount() {
		return entities.size();
	}
	
	public State getState() {
		return state;
	}
	
	public Menu getMainMenu() {
		return mainMenu;
	}
	

}
