package com.kulthro.games.game_engine;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;

public class Main {
	
	private final static int WIDTH = 800;
	private final static int HEIGHT = 600;
	
	public static void main(String[] args) {
		
		//Creates Display of WIDTH x HEIGHT
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		// Sets up LWJGL with OpenGL.
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, 0, HEIGHT, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
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
		
		glVertex2f(0,HEIGHT);
		glVertex2f(WIDTH,HEIGHT);
		
		glColor3f(0.3f,0.8f,1f);
		
		glVertex2f(WIDTH,0);
		glVertex2f(0,0);
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
