package com.kulthro.games.game_engine;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


import static org.lwjgl.opengl.GL11.*;

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
		while(!Display.isCloseRequested()) {
	
			tick();
			Screen.draw();
			
			//Update the screen
			Display.update();
			//Keeps a constant frame rate
			Display.sync(FRAME_RATE);
		}
	}
	
	public static void tick() {
		
	}	
}
