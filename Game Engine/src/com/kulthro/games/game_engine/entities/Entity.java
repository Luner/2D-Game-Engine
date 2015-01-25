package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.*;

public abstract class Entity {

	private Vector2f position;
	private Vector2f direction;
	
	public Entity() {
		this(0,0,0,0);
	}
	
	public Entity(float x, float y) {
		this(x, y, 0, 0);
	}
	
	public Entity(float x, float y, float xx, float yy) {
		position = new Vector2f(x,y);
		direction = new Vector2f(xx,yy);
	}
	
}
