package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.util.Vector2f;

public class Mob extends Entity {

	private float health;
	
	public Mob(Vector2f position, Vector2f direction, float width, float height, float health) {
		super(position, direction, width, height);
		this.health = health;
	}
	
	public void damage (float damage){
		this.health = this.health - damage;
	}
	
	public void getDamage(float force) {
		damage(force);
	}
}
