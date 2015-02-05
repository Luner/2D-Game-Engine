package com.kulthro.games.game_engine.files;

import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class ImageReader {

	public ImageReader(){}

	public Texture loadTexture(String key, String type){
		try { return TextureLoader.getTexture(type, getClass().getResourceAsStream("images/" + key + "." + type)); 
		} catch (IOException ex) {
			System.out.println("Failure loading texture: " + key + ", which should be a " + type);
		} return null;
	}	
}
