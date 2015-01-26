package com.kulthro.games.game_engine.files;

import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

//Create an instance of this and then call upon the loadtexture function to return a texture
public class ImageReader {
	
	public ImageReader(){}
	
	//The key is the name of the file, the type is the type of image ie. png, jpg, ect...
	public Texture loadTexture(String key, String type){
		try{
			return TextureLoader.getTexture(type, getClass().getResourceAsStream("images/" + key + "." + type));
		}
		catch (IOException ex){
			System.out.println("Failure loading texture: " + key + ", which should be a " + type);
			}
		return null;
	}	
}
