package com.kulthro.games.game_engine.entities;

import org.newdawn.slick.opengl.Texture;

import com.kulthro.games.game_engine.*;
import com.kulthro.games.game_engine.util.Vector2f;

public abstract class Entity extends Quad{

	protected Texture tex;
	
	public Entity(float positionX, float positionY, float width, float height) {
		this(positionX, positionY, 0, 0, width, height);
	}
	
	
	public Entity(float positionX, float positionY, float directionX, float directionY, float width, float height) {
		super(new Vector2f(positionX,positionY), new Vector2f(directionX,directionY), width, height);
	}

	
	public Entity(Vector2f position, Vector2f direction, float width, float height) {
		super(position, direction, width, height);
	}


	public Texture getTexture() {
		return tex;
	}
	
	public void setTexture(Texture texture) {
		this.tex = texture;
	}
	
	public void update() {
		move();
	}
}
