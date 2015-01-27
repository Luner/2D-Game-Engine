package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.*;

public abstract class Entity {

	private Vector2f position;
	private Vector2f direction;
	
	public Entity(float positionX, float positionY) {
		this(positionX, positionY, 0, 0);
	}
	
	public Entity(float positionX, float positionY, float directionX, float directionY) {
		this(new Vector2f(positionX,positionY), new Vector2f(directionX,directionY));
	}

	public Entity(Vector2f position, Vector2f direction){
		this.position = position;
		this.direction = direction;
	}
	
	private void move() {
		this.position = this.position.add(direction);
	}
	
	public void update() {
		move();
	}

	public Vector2f getPosition() {
		return position;
	}
	
	public Vector2f getDirection() {
		return direction;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public void setDirection(Vector2f direction) {
		this.direction = direction;
	}
}
