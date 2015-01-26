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

	private State state = State.Menu;
	private Menu main = new Menu(new SquareButton[] {
			new SquareButton(200,400,600,500, "Start", "png"),
			new SquareButton(200,250,600,350, "Slime", "png"),
			new SquareButton(200,100,600,200, "Exit", "png")
	});

	private ArrayList<Entity> entities;

	public Game() {
		entities = new ArrayList<Entity>();
		entities.add(new Player(100,400));

		Screen.initDisplay();
		Screen.initGL();
		this.run();
		Screen.closeDisplay();

	}

	public static void main(String[] args) {
		Game game = new Game();
	}

	//-------------------------------------------------- 
	//  Game Logic functions
	//-------------------------------------------------- 

	private void run(){
		while(Screen.screenIsOpen()) {
			tick();
			Screen.draw();
			
			switch(state){
			case Menu:

				//initializes the menu
				if(main.isInitialized() == false){
						main.initMenu();
				}
				//Returns the name of the button if it is clicked
				if(Mouse.isButtonDown(0)){
					String key = main.click(Mouse.getX(), Mouse.getY());
					if(key != ""){
						System.out.println(key);
						if(key.equals("Exit")){
							Screen.closeDisplay();
						}
					}
				}
				main.update();
				break;

			case Game:

				break;
			}

			Screen.updateScreen();
		}
	}

	public static void tick() {
	}	
}
