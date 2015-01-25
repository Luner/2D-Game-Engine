package com.kulthro.games.game_engine;

import java.util.ArrayList;

import com.kulthro.games.game_engine.entities.Entity;

public class Game {
	
	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	public final static int FRAME_RATE = 60;
	public final static String TITLE = "Kulthro";

	private ArrayList<Entity> entities;
	
	public static void main(String[] args) {
		Game game = new Game();
		Screen.initDisplay(game);
		Screen.initGL();
		game.run();
		Screen.closeDisplay();
	}
	
	//-------------------------------------------------- 
	//  Game Logic functions
	//-------------------------------------------------- 
	
	private void run(){
		while(Screen.screenIsOpen()) {
			tick();
			Screen.draw();
		}
	}
	
	public static void tick() {
		
	}	
}
