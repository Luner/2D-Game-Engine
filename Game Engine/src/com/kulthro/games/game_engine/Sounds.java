package com.kulthro.games.game_engine;

import org.newdawn.slick.openal.Audio;

import com.kulthro.games.game_engine.files.SoundReader;

public class Sounds {

	//These May Later be Stored Inside their Respective Classes
	public static Audio BUTTON;
	public static Audio BUTTON_PRESS;
	
	//Globally Initializes the Sounds (To Be Changed)
	public static void initSounds(){
		BUTTON = getAudio("Button");
		BUTTON_PRESS = getAudio("ButtonPress");		
	}
	
	//Returns the Sound with the File Name Being the Key
	public static Audio getAudio(String key){
		SoundReader load = new SoundReader();
		return load.loadSound(key);
	}	
}
