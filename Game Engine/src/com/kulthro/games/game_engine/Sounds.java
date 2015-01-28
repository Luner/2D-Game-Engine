package com.kulthro.games.game_engine;

import org.newdawn.slick.openal.Audio;

import com.kulthro.games.game_engine.files.SoundReader;

public class Sounds {
	
	public static Audio BUTTON;
	
	public static void initSounds(){
		BUTTON = getAudio("Button");
	}
	public static Audio getAudio(String key){
		SoundReader load = new SoundReader();
		return load.loadSound(key);
	}	
}
