package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.*;

public abstract class Entity {

	private Vector2f vector;
	
	public Entity() {
		vector = new Vector2f(0,0); 
	}
	
	public Entity(float x, float y) {
		vector = new Vector2f(x,y);
	}
	
}
