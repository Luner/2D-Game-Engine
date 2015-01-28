package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.*;
import com.kulthro.games.game_engine.util.Vector2f;

public abstract class Entity {

	private Vector2f position;
	private Vector2f direction;
	private float width;
	private float height;
	
	public Entity(float positionX, float positionY, float width, float height) {
		this(positionX, positionY, 0, 0, width, height);
	}
	
	public Entity(float positionX, float positionY, float directionX, float directionY, float width, float height) {
		this(new Vector2f(positionX,positionY), new Vector2f(directionX,directionY), width, height);
	}

	public Entity(Vector2f position, Vector2f direction, float width, float height){
		this.position = position;
		this.direction = direction;
		this.height = height;
		this.width = width;
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
	
	public float getWidth(){
		return width;
	}

	public float getHeight(){
		return height;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public void setDirection(Vector2f direction) {
		this.direction = direction;
	}
	
	public void setWidth(float width){
		this.width = width;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
}
