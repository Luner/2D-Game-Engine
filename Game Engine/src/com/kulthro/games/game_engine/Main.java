package com.kulthro.games.game_engine;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {
	public static void main(String[] args) {
		
		//Creates Display of 800x600
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		while(!Display.isCloseRequested()) {
			
			tick();
			draw();
			
			// Update the screen
			Display.update();
			Display.sync(60);
		}
		
		//Closes Display Window
		Display.destroy();
		
	}
	
	/* Rendering functions*/
	public static void draw() {
		drawBackground();
	}
	
	public static void drawBackground() {
		
	}
	
	/*Game Logic Functions*/
	public static void tick() {
		
	}
	
}
