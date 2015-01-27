package com.kulthro.games.game_engine.entities;

import org.newdawn.slick.opengl.Texture;

import com.kulthro.games.game_engine.Vector2f;

public abstract class Mob extends Entity {

	private float health;
	protected Texture tex;

	public Mob(float positionX, float positionY, float health) {
		super(positionX, positionY);
		this.health = health;
	}
	
	public Mob(float positionX, float positionY, float directionX, float directionY, float health) {
		super(positionX, positionY, directionX, directionY);
		this.health = health;
	}
	
	public Mob(Vector2f position, Vector2f direction, float health) {
		super(position, direction);
		this.health = health;
	}
	
	public void damage (float damage){
		this.health = this.health - damage;
	}
	
	public Texture getTexture() {
		return tex;
	}
	
	public void setTexture(Texture texture) {
		this.tex = texture;
	}
}
