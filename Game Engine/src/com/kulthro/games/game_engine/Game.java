package com.kulthro.games.game_engine;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.kulthro.games.game_engine.entities.*;
import com.kulthro.games.game_engine.game.*;
import com.kulthro.games.game_engine.menu.*;
import com.kulthro.games.game_engine.util.Input;

public class Game {

	public Game(){}
	private State state = State.Menu;

	private Menu mainMenu, options, credits, chooseEnvironment;
	private Menu[] menuSystem = new Menu[4];

	private ArrayList<Entity> mobs;
	private ClassicControls control;

	private Level level;
	private Environment space, earth, moon;
	
	public void initMenus(){
		mainMenu = new Menu(new MenuItem[] {
				new SquareButton(200,400,600,500, "Exit","png","Exit"),
				new SquareButton(200,250,600,350, "Options", "png", "toOptions"),
				new SquareButton(200,100,600,200, "Start", "png", "toChoose"),
				new TextBox(10, "Main Menu", Color.white)});

		chooseEnvironment = new Menu(new MenuItem[] {
				new TextBox(150, "Space", Color.white, "toSpace"),
				new TextBox(250, "Earth", Color.white, "toEarth"),
				new TextBox(350, "Moon", Color.white, "toMoon")
		});
		options = new Menu(new MenuItem[] {
				new SquareButton(200,400,600,500, "Exit", "png", "toMain"),
				new SquareButton(200,250,600,350, "Options", "png"),
				new SquareButton(200,100,600,200, "Options", "png"),
				new TextBox(10, "Options", Color.white)});

		credits = new Menu(new SquareButton[] {
				new SquareButton(200,400,600,500, "Exit", "png"),
				new SquareButton(200,250,600,350, "Start", "png"),
				new SquareButton(200,100,600,200, "Start", "png")
		});
		menuSystem[0]=mainMenu;
		menuSystem[1]=options;
		menuSystem[2]=credits;
		menuSystem[3]=chooseEnvironment;
	}

	public void initMobs(){
		//TEMP MOBS AND CONTROL
		mobs = new ArrayList<Entity>();
		mobs.add(new Player(300, 300, 0, 0, 64, 64, 100));
		mobs.add(new Player(1000, 20, 0, 0, 64, 64, 100));
		control = new ClassicControls(mobs.get(0));

		for(Entity e : mobs) {
			e.setTexture(Render.getTexture("default","png"));
		}
	}

	public void drawGame() {
		Screen.clearScreen();
		drawBackground();
		drawEntities();
	}

	public void drawEntities() {
		for(Entity e : mobs) {
			Render.renderQuad(e.getPosition().getX(), e.getPosition().getY(), e.getPosition().getX() + e.getWidth(), e.getPosition().getY() + e.getHeight(), e.getTexture());
		}
	}

	public static void drawBackground() {
		Render.renderQuadVerticleGradient(0, 0, Screen.WIDTH, Screen.HEIGHT, 0.1f, 0.4f, 0.8f, 0.3f, 0.8f, 1f);
	}

	public void tick() {
		level.update();
	}

	private void run() {
		initMenus();
		initMobs();

		while(true) {

			Screen.clearScreen();

			switch(state) {
			case Menu:

				//initializes the menu
				if(menuSystem[Menu.index].isInitialized() == false){
					menuSystem[Menu.index].initMenu();
				}

				//Returns the action of the button if it is clicked
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
						else if(action.equals("toChoose")){
							Menu.index = 3;
							break;
						}
						else if(action.equals("toSpace"))
						{
							space = new EnvironmentGravity(0);
							level = new Level(space, mobs);
							state = State.Game;
							break;
						}
						else if(action.equals("toEarth"))
						{
							earth = new EnvironmentGravity(0.2f);
							level = new Level(earth, mobs);
							state = State.Game;
							break;
						}
						else if(action.equals("toMoon"))
						{
							moon = new EnvironmentGravity(0.09f);
							level = new Level(moon, mobs);
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
				drawGame();
				break;
			}
			Input.Update();
			Screen.updateScreen();

		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		Screen.initDisplay();
		Screen.initGL();
		Screen.initFont();
		Sounds.initSounds();
		game.run();
	}
}
