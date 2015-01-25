package com.kulthro.games.game_engine;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Screen {
	
	private Game game;
	
	/*Initialized the display*/
	public static void initDisplay(Game game) {
		game = game;
		try {
			Display.setDisplayMode(new DisplayMode(Game.WIDTH,Game.HEIGHT));
			Display.setTitle(Game.TITLE);
			Display.create();
		}

		catch (LWJGLException e) {
			Sys.alert("Error","Unable to create display.");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void closeDisplay() {
		Display.destroy();
		System.exit(0);
	}
	
	public static boolean initGL(){
		//Sets up LWJGL with OpenGL.
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		//(0,0) at bottom left & (WIDTH,HEIGHT) at top right
		glOrtho(0,Game.WIDTH,0,Game.HEIGHT,1,-1);
		glMatrixMode(GL_MODELVIEW);
		
		//This enables the use of textures
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND); 
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		return true;
	}
	
	public static boolean screenIsOpen() {
		return !Display.isCloseRequested();
	}
	
	public static void updateScreen() {
		//Update the screen
		Display.update();
		//Keeps a constant frame rate
		Display.sync(Game.FRAME_RATE);
	}
	
	/* Rendering functions*/
	public static void draw() {
		clearScreen();
		
		drawBackground();
		drawBlocks();
		drawEntities();
	}
	
	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
	}
	
	public static void drawBackground() {
		glBegin(GL_QUADS);
		glColor3f(0.1f,0.4f,0.8f);
		glVertex2f(0,Game.HEIGHT);			//Left, Top
		glVertex2f(Game.WIDTH,Game.HEIGHT);	//Right, Top
		glColor3f(0.3f,0.8f,1f);
		glVertex2f(Game.WIDTH,0);			//Right, Bottom
		glVertex2f(0,0);					//Bottom, Left
		glEnd();
	}
	
	public static void drawBlocks() {
		
	}
	
	public static void drawEntities() {
		
	}
	
}
