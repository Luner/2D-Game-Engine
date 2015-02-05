package com.kulthro.games.game_engine;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.TrueTypeFont;

public class Screen {

	public final static String TITLE = "Kulthro";
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	public final static int FRAME_RATE = 60;
	
	public static TrueTypeFont font;
	public final static int fontSize = 56;
	
	//Initialized the display
	public static void initDisplay() {		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
		} catch (LWJGLException e){
			Sys.alert("Error","Unable to create display.");
			e.printStackTrace();
			System.exit(0);
		}
	}

	//Loads a Java Font
	public static void initFont() {
		Font awtFont = new Font("Copperplate Gothic Bold", Font.BOLD, fontSize);
		font = new TrueTypeFont(awtFont, true);
	}

	//Initializes LWJGL with OpenGL.
	public static boolean initGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,WIDTH,HEIGHT,0,1,-1);	
		glMatrixMode(GL_MODELVIEW);
		
		//This Enables the Use of Textures
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND); 
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		return true;
	}

	public static void updateScreen() {	
		//Update the Screen
		Display.update();
		//Keeps the Screen at This Constant Frame Rate
		Display.sync(FRAME_RATE);
	}

	public static void closeDisplay() {
		Display.destroy();
		System.exit(0);
	}
	
	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
	}
}
