package com.kulthro.games.game_engine;

import java.util.ArrayList;

import com.kulthro.games.game_engine.*;
import com.kulthro.games.game_engine.camera.*;
import com.kulthro.games.game_engine.entities.*;
import com.kulthro.games.game_engine.menu.*;

public class Game {
	
	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	public final static int FRAME_RATE = 60;
	public final static String TITLE = "Kulthro";

	private ArrayList<Entity> entities;

	public Game() {
		entities = new ArrayList<Entity>();
		entities.add(new Player(100,400));

		Screen.initDisplay(this);
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
			Screen.updateScreen();
		}
	}
	
	public static void tick() {
		
	}	
}
