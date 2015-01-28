package com.kulthro.games.game_engine;

import org.newdawn.slick.openal.Audio;

import com.kulthro.games.game_engine.files.SoundReader;

public class Sounds {

	public static Audio BUTTON;
	public static Audio BUTTON_PRESS;
	
	public static void initSounds() {
		BUTTON = getAudio("Button");
		BUTTON_PRESS = getAudio("ButtonPress");		
	}
	
	public static Audio getAudio(String key) {
		SoundReader load = new SoundReader();
		return load.loadSound(key);
	}
}
