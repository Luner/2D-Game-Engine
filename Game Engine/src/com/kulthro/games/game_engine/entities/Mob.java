package com.kulthro.games.game_engine.entities;

import org.newdawn.slick.opengl.Texture;

public abstract class Mob extends Entity {
	
	private Texture tex;

	private int health;
	
	public Mob() {
		health = 100;
	}
	
	public Mob(float x, float y) {
		super(x, y);
	}
	
	public Texture getTexture() {
		return tex;
	}
	
	public void setTexture(Texture texture) {
		this.tex = texture;
	}
	
}
