package com.kulthro.games.game_engine;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.kulthro.games.game_engine.entities.*;
import com.kulthro.games.game_engine.game.*;
import com.kulthro.games.game_engine.menu.*;
import com.kulthro.games.game_engine.util.Input;

public class Game {

	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	public final static int FRAME_RATE = 60;
	public final static String TITLE = "Kulthro";
	private State state = State.Menu;

	private Menu mainMenu, options, credits;
	private Menu[] menuSystem = new Menu[3];
	private ClassicControls control;
	private ArrayList<Entity> mobs;
	private Level level;
	private Environment environment;
	public Game() {
		Screen.initDisplay(this);
		Screen.initGL();
		Screen.initFont();
		Sounds.initSounds();
		
		mobs = new ArrayList<Entity>();
		mobs.add(new Player(300, 300, 0, 0, 64, 64, 100));
		control = new ClassicControls(mobs.get(0));
		
		//an environment with gravity at 2.0f
		environment = new EnvironmentEarth(0.2f);
		
		level = new Level(environment, mobs);
		//temp addition to textures
		for(Entity e : getMobs()) {
			e.setTexture(Render.getTexture("Slime", "png"));
		}
		
		//*********** Temp menu inits (will be in data files eventually)
		mainMenu = new Menu(new SquareButton[] {
						new SquareButton(200,400,600,500, "Exit", "png", "Exit"),
						new SquareButton(200,250,600,350, "Options", "png", "toOptions"),
						new SquareButton(200,100,600,200, "Start", "png", "Start")
				},
				new TextBox[] {
						new TextBox(10, "Main Menu", Color.white)
				});
		options = new Menu(new SquareButton[] {
				new SquareButton(200,400,600,500, "Exit", "png", "toMain"),
				new SquareButton(200,250,600,350, "Options", "png"),
				new SquareButton(200,100,600,200, "Options", "png")
		},
		new TextBox[] {
				new TextBox(270, 10, "Options", Color.white)
		});
		credits = new Menu(new SquareButton[] {
				new SquareButton(200,400,600,500, "Exit", "png"),
				new SquareButton(200,250,600,350, "Start", "png"),
				new SquareButton(200,100,600,200, "Start", "png")
		});
		menuSystem[0]=mainMenu;
		menuSystem[1]=options;
		menuSystem[2]=credits;
		//***********
		
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
				
				if(Input.getMouseUp(0)){
					String action = menuSystem[Menu.index].click(Input.getMousePosition());
					if(!action.equals("none") && !action.equals("")){
						Sounds.BUTTON_PRESS.playAsSoundEffect(1.0f, 1.0f, false); //sound effect when button pressed
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
				if(Input.getMouse(0)){
					menuSystem[Menu.index].mouseDown(Input.getMousePosition());
				}
				menuSystem[Menu.index].update(Input.getMousePosition());
				break;

			case Game:
				/*Game Stuff Here*/
				control.update();
				tick();
				Screen.drawGame();
				break;
			}
			Input.Update();
			Screen.updateScreen();

		}
	}

	public void tick() {
		//Updates level
		level.update();
	}

	//-------------------------------------------------- 
	//  Getters and Setters
	//-------------------------------------------------- 

	public ArrayList<Entity> getMobs() {
		return mobs;
	}

	public int getEntityCount() {
		return mobs.size();
	}

	public State getState() {
		return state;
	}

	public Menu getMainMenu() {
		return mainMenu;
	}


}
