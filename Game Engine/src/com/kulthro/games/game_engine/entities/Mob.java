package com.kulthro.games.game_engine.entities;

public abstract class Mob extends Entity {

	private int health;
	private int width;
	private int height;
	
	public Mob() {
		this(0,0);
	}
	
	public Mob(float x, float y) {
		super(x,y);
		health = 100;
	}
	
}
