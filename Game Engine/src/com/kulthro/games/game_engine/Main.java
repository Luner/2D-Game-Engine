package com.kulthro.games.game_engine;

public class Main {
	
	public static void main(String[] args) {
		Game game = new Game();
		Screen.initDisplay();
		Screen.initGL();
		Screen.initFont();
		Sounds.initSounds(); //Will Eventually be Initialized in a way Similar to Textures
		game.run();
    }

}
