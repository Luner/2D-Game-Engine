package com.kulthro.games.game_engine;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import com.kulthro.games.game_engine.entities.*;
import com.kulthro.games.game_engine.menu.*;

public class Game {

	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	public final static int FRAME_RATE = 60;
	public final static String TITLE = "Kulthro";
	private State state = State.Menu;

	private Menu mainMenu = new Menu(
			new SquareButton[] {
					new SquareButton(200,400,600,500, "Exit", "png", "Exit"),
					new SquareButton(200,250,600,350, "Options", "png", "toOptions"),
					new SquareButton(200,100,600,200, "Start", "png", "Start")
			},
			new TextBox[] {
					new TextBox(235, 10, "Main Menu", Color.white)
			});

	private Menu options = new Menu(new SquareButton[] {
			new SquareButton(200,400,600,500, "Exit", "png", "toMain"),
			new SquareButton(200,250,600,350, "Options", "png"),
			new SquareButton(200,100,600,200, "Options", "png")
	},
	new TextBox[] {
			new TextBox(270, 10, "Options", Color.white)
	});

	private Menu credits = new Menu(new SquareButton[] {
			new SquareButton(200,400,600,500, "Exit", "png"),
			new SquareButton(200,250,600,350, "Start", "png"),
			new SquareButton(200,100,600,200, "Start", "png")
	});

	private Menu[] menuSystem = {mainMenu, options, credits};

	private ArrayList<Enemy> entities;

	public Game() {
		entities = new ArrayList<Enemy>();
		//Test Adding players
		entities.add(new Enemy(100,400, 32, 32, 100));
		entities.add(new Enemy(310,200, 32, 32, 100));
		entities.add(new Enemy(700, 40, 32, 32, 100));



		Screen.initDisplay(this);
		Screen.initGL();

		//temp addition to textures
		for(Enemy e : getEntities()) {
			e.setTexture(Render.getTexture("Slime", "png"));
		}

		Screen.initFont();
		this.run();
		Screen.closeDisplay();

	}

	public static void main(String[] args) {
		Game game = new Game();
	}
	/*------------------------------------------------- 
	/  Game Logic functions
	/-------------------------------------------------- 
	/ One tick is equal to one frame. Rather than edit the while loop in run(), please add all tick methods within tick();
	 */

	private void run() {

		while(Screen.screenIsOpen()) {

			Screen.clearScreen();

			switch(state) {
			case Menu:

				//initializes the menu
				if(menuSystem[Menu.index].isInitialized() == false){
					menuSystem[Menu.index].initMenu();
				}
				//Returns the name of the button if it is clicked
				if(Mouse.isButtonDown(0)){
					String action = menuSystem[Menu.index].click(Mouse.getX(),Game.HEIGHT - Mouse.getY());
					if(!action.equals("none") && !action.equals("")){
						System.out.println(action);
						if(action.equals("Exit")){
							Screen.closeDisplay();
						}
						else if(action.equalsIgnoreCase("toMain")){
							Menu.index = 0;
							break;
						}
						else if(action.equalsIgnoreCase("toOptions")){
							Menu.index = 1;
							break;
						}
						else if(action.equals("toCredits")){
							Menu.index = 2;
							break;
						}
						else if(action.equals("Start")){
							state = State.Game;
							break;
						}
					}
				}
				menuSystem[Menu.index].update();
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

	public ArrayList<Enemy> getEntities() {
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
