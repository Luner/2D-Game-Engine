package com.kulthro.games.game_engine.entities;

import org.newdawn.slick.opengl.Texture;

public abstract class Mob extends Entity {
	
	private int health = 100;
	protected Texture tex;
	
	public Mob(float x, float y) {
		super(x, y);
	}
	
	public void damage (int damage){
		this.health = this.health - damage;
	}
	
	public Texture getTexture() {
		return tex;
	}
	
	public void setTexture(Texture texture) {
		this.tex = texture;
	}
}
