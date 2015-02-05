package com.kulthro.games.game_engine.entities;

import org.newdawn.slick.opengl.Texture;

import com.kulthro.games.game_engine.*;
import com.kulthro.games.game_engine.util.Vector2f;

public abstract class Entity extends Quad{

	protected Texture tex;

	public Entity(Vector2f position, Vector2f direction, float width, float height) {
		super(position, direction, width, height);
	}

	public Texture getTexture() {
		return tex;
	}
	
	public Entity setTexture(Texture texture) {
		this.tex = texture;
		return this;
	}
	
	public void update() {
		move();
	}
}
