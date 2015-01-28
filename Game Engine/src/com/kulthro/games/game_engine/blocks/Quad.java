package com.kulthro.games.game_engine.blocks;

import com.kulthro.games.game_engine.util.Vector2f;

public class Quad extends Block {
	
	public Quad(Vector2f position, float width, float height) {
		super(position, width, height);
	}
	
	public void move() {
		this.position = this.position.add(direction);
	}
	
	public Vector2f getDirection() {
		return direction;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	 
	public void setDirection(Vector2f direction) {
		this.direction = direction;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public float area() {
		return this.width * this.height;
	}

}
