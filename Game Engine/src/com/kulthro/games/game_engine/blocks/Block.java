package com.kulthro.games.game_engine.blocks;

import com.kulthro.games.game_engine.Vector2f;
import com.kulthro.games.game_engine.entities.Damageable;

public abstract class Block implements Damageable {
	//collision with a circle bounce off opposite of the direction from the circle
	protected Vector2f position;
	protected Vector2f direction;
	
	protected float width;
	protected float height;
	private boolean passable;
	private boolean breakable;
	
	public Block(Vector2f position, float width, float height) {
		this.position = position;
		this.width = width;
		this.height = height;
	}
	
	public void getDamage(float force) {
		if(breakable) {
			//Make block disappear or "break"
		}
	}
	
}
