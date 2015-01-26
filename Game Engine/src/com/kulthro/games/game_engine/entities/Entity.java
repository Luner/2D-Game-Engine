package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.*;

public abstract class Entity {

	private Vector2f position;
	private Vector2f direction;
	
	public Entity() {
		this(0,0,0,0);
	}
	
	public Entity(float positionX, float positionY) {
		this(positionX, positionY, 0, 0);
	}
	
	public Entity(float positionX, float positionY, float directionX, float directionY) {
		position = new Vector2f(positionX,positionY);
		direction = new Vector2f(directionX,directionY);
	}
	
	private void move() {
		this.position = this.position.add(direction);
	}
	
	public void update() {
		move();
	}
	
	public float getX() {
		return position.getX();
	}
	
	public float getY() {
		return position.getY();
	}
	
}
