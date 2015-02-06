package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.util.Vector2f;

public class Quad{

	protected Vector2f position;
	protected float width;
	protected float height;

	public Quad(Vector2f position, float width, float height) {
		this.position = position;
		this.width = width;
		this.height = height;
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
