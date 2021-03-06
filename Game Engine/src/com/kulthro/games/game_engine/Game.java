package com.kulthro.games.game_engine;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.kulthro.games.game_engine.entities.*;
import com.kulthro.games.game_engine.game.*;
import com.kulthro.games.game_engine.menu.*;
import com.kulthro.games.game_engine.util.Input;
import com.kulthro.games.game_engine.util.Vector2f;

public class Game {

	public Game(){}
	private State state = State.Menu;

	//All of the Different Menus are Listed Here
	private Menu mainMenu, options, credits, chooseEnvironment;
	private Menu[] menuSystem = new Menu[4];

	private ArrayList<Entity> entities;
	private ArrayList<Block> blocks;
	private ClassicControls control;

	//All of the Possible Environments are Listed Here
	private Environment space, earth, moon;
	private Level level;

	public void run() {
		initMenus();
		initBlocks();
		initEntities();
		initControl();
		
		//For Some Reason Textures Do Not Work When You Are 
		while(true) {
			switch(state) {
			case Menu:

				//Initializes the Menu; Will Uninitialize When the State Changes (To Be Implemented)
				if(menuSystem[Menu.index].isInitialized() == false)
					menuSystem[Menu.index].initMenu();

				//Returns the Action if the Mouse Button 0 is Released
				if(Input.getMouseUp(0)){
					String action = menuSystem[Menu.index].click(Input.getMousePosition());
					if(!action.equals("none") && !action.equals("")){

						//Sound Effect When Button Pressed
						Sounds.BUTTON_PRESS.playAsSoundEffect(1.0f, 1.0f, false); 

						//Checks what Action the Button was Binded to and Exicuted this Action
						if(action.equals("Exit")){
							Screen.closeDisplay();
						} else if(action.equalsIgnoreCase("toMain")) {
							Menu.index = 0;
							break;
						} else if(action.equalsIgnoreCase("toOptions")) {
							Menu.index = 1;
							break;
						} else if(action.equals("toCredits")) {
							Menu.index = 2;
							break;
						} else if(action.equals("toChoose")) {
							Menu.index = 3;
							break;
						} else if(action.equals("toSpace")) {
							space = new EnvironmentGravity(0);
							addFloor();
							level = new Level(space, entities, blocks);
							state = State.Game;
							break;
						} else if(action.equals("toEarth")) {
							earth = new EnvironmentGravity(0.3f);
							addFloor(); 
							addObsticals();
							level = new Level(earth, entities, blocks);
							state = State.Game;
							break;
						} else if(action.equals("toMoon")) {
							moon = new EnvironmentGravity(0.09f);
							addFloor();
							level = new Level(moon, entities, blocks);
							state = State.Game;
							break;
						}
					}
				}

				//Updates the Menu System
				menuSystem[Menu.index].update(Input.getMousePosition());
				break;

			case Game:
				control.update();
				tick();
				break;
			}

			Input.Update();
			Screen.updateScreen();
		}
	}

	private void tick() {
		//Updates the Level Every "Tick"
		level.update();
	}

	//Initialized the Different Menus
	private void initMenus(){
		mainMenu = new Menu(new MenuItem[] {
				new SquareButton(200,400,600,500, "Exit","png","Exit"),
				new SquareButton(200,250,600,350, "Options", "png", "toOptions"),
				new SquareButton(200,100,600,200, "Start", "png", "toChoose"),
				new TextBox(10, "Main Menu", Color.white)});

		chooseEnvironment = new Menu(new MenuItem[] {
				new TextBox(150, "Space", Color.white, "toSpace"),
				new TextBox(250, "Earth", Color.white, "toEarth"),
				new TextBox(350, "Moon", Color.white, "toMoon")});

		options = new Menu(new MenuItem[] {
				new SquareButton(200,400,600,500, "Exit", "png", "toMain"),
				new SquareButton(200,250,600,350, "Options", "png"),
				new SquareButton(200,100,600,200, "Options", "png"),
				new TextBox(10, "Options", Color.white)});

		credits = new Menu(new SquareButton[] {
				new SquareButton(200,400,600,500, "Exit", "png"),
				new SquareButton(200,250,600,350, "Start", "png"),
				new SquareButton(200,100,600,200, "Start", "png")});

		menuSystem[0]=mainMenu;
		menuSystem[1]=options;
		menuSystem[2]=credits;
		menuSystem[3]=chooseEnvironment;
	}

	//Initializes the Entities
	private void initEntities(){
		entities = new ArrayList<Entity>();
		entities.add(new Mob(new Vector2f(300, 300), new Vector2f(0, 0), 32, 32, 100).setTexture(Render.getTexture("Slime", "png")));
	}

	private void initBlocks(){
		blocks = new ArrayList<Block>();
	}

	private void addFloor(){
		blocks.add(new Block(new Vector2f(0, Screen.HEIGHT - 64), Screen.WIDTH, 64).setTexture(Render.getTexture("default","png")));
	}

	private void addObsticals(){
		blocks.add(new Block(new Vector2f(900, 200), 64, 64).setTexture(Render.getTexture("default","png")));
		blocks.add(new Block(new Vector2f(600, 400), 64, 64).setTexture(Render.getTexture("default","png")));
		blocks.add(new Block(new Vector2f(400, 600), 64, 64).setTexture(Render.getTexture("default","png")));
	}

	//Binds the ClassicControls to the first Entity
	private void initControl(){
		control = new ClassicControls(entities.get(0), 5);
	}
}
