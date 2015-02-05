package com.kulthro.games.game_engine.files;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;

public class SoundReader {
	
	public Audio loadSound(String key) {	  
		try {
			return AudioLoader.getAudio("WAV", getClass().getResourceAsStream("sounds/" + key + ".wav"));
		} catch (IOException e) {
			e.printStackTrace();
		} return null;
	}
}
