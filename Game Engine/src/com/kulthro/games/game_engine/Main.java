package com.kulthro.games.game_engine;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class Main {
	
	private final static int WIDTH = 800;
	private final static int HEIGHT = 600;
	private final static int FRAME_RATE = 60;
	private final static String TITLE = "Kulthro";
	
	private void run(){
		while(!Display.isCloseRequested()) {
	
			tick();
			draw();
			
			//Update the screen
			Display.update();
			//Keeps a constant frame rate
			Display.sync(FRAME_RATE);
		}
		close();
	}

	/*Initialized the display*/
	private static void initDisplay(){
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
		}

		catch (LWJGLException e) {
			Sys.alert("Error","Unable to create display.");
			System.exit(0);
		}
	}
	
	private static boolean initGL(){
		//Sets up LWJGL with OpenGL.
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		//(0,0) at bottom left & (WIDTH,HEIGHT) at top right
		glOrtho(0,WIDTH,0,HEIGHT,1,-1);
		glMatrixMode(GL_MODELVIEW);
		
		//This enables the use of textures
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND); 
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		return true;
	}
		
	
	public static void main(String[] args) {
		Main screen = new Main();
		initDisplay();
		initGL();
		screen.run();
	}

	/*Closes display window and cleans up*/
	private void close(){
		Display.destroy();
		System.exit(0);
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
		glVertex2f(0,HEIGHT);		//TOP RIGHT
		glVertex2f(WIDTH,HEIGHT);	//TOP LEFT
		
		glColor3f(0.3f,0.8f,1f);
		glVertex2f(WIDTH,0);		//BOTTOM RIGHT
		glVertex2f(0,0);			//BOTTOM LEFT
		glEnd();
	}
	
	public static void drawBlocks() {
		
	}
	
	public static void drawEntities() {
		
	}
	
	/*Game Logic Functions*/
	public static void tick() {
		
	}	
}