package com.kulthro.games.game_engine.entities;

import org.newdawn.slick.opengl.Texture;

import com.kulthro.games.game_engine.Vector2f;

public abstract class Mob extends Entity {

	private float health;
	private float speed = 1f;
	
	protected Texture tex;

	public Mob(float positionX, float positionY, float width, float height, float health) {
		super(positionX, positionY, width, height);
		this.health = health;
	}
	
	public Mob(float positionX, float positionY, float directionX, float directionY, float width, float height, float health) {
		super(positionX, positionY, directionX, directionY, width, height);
		this.health = health;
	}
	
	public Mob(Vector2f position, Vector2f direction, float width, float height, float health) {
		super(position, direction, width, height);
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
