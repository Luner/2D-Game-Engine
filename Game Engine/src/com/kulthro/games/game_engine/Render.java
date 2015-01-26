package com.kulthro.games.game_engine;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Render {
	public static void renderQuad(float leftX,float bottomY,float rightX,float topY, Texture tex){
		tex.bind();
		glBegin(GL_QUADS);
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		GL11.glTexCoord2f(0.0f,1.0f);
		GL11.glVertex2f(leftX, bottomY);    // Bottom Left Of The Quad
		GL11.glTexCoord2f(1.0f,1.0f);
		GL11.glVertex2f(rightX, bottomY);   // Bottom Right Of The Quad 
		GL11.glTexCoord2f(1.0f,0.0f);
		GL11.glVertex2f(rightX, topY);		// Top Right Of The Quad 
		GL11.glTexCoord2f(0.0f,0.0f);
		GL11.glVertex2f(leftX, topY);  		// Top Left Of The Quad 
		glEnd();
		glBindTexture(GL_TEXTURE_2D, 0);
	}