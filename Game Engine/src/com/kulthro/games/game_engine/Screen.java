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

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import com.kulthro.games.game_engine.entities.Entity;

public class Screen {

	private static Game game;
	static TrueTypeFont font;
	static TrueTypeFont font2;
	
	/*Initialized the display*/
	public static void initDisplay(Game game) {
		Screen.game = game;
		
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
	
	 
	public static void initFont() {
		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
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
		glOrtho(0,Game.WIDTH,Game.HEIGHT,0,1,-1);
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
	public static void drawGame() {
		clearScreen();

		drawBackground();

		drawBlocks();
		drawEntities();
	}

	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
	}

	public static void drawBackground() {
		Render.renderQuadVerticleGradient(0, 0, Game.WIDTH, Game.HEIGHT, 0.1f, 0.4f, 0.8f, 0.3f, 0.8f, 1f);
	}

	public static void drawBlocks() {

	}

	public static void drawEntities() {
		font.drawString(100, 50, "THE LIGHTWEIGHT JAVA GAMES LIBRARY", Color.darkGray);
		for(Entity e : game.getEntities()) {
			Render.renderQuad(e.getPosition().getX()-5, e.getPosition().getY()-5, e.getPosition().getX()+5, e.getPosition().getY()+5, Render.getTexture("Slime","png"));
		}

	}

	public static void drawMenu() {

	}

}
