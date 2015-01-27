package com.kulthro.games.game_engine.entities;

public class Enemy extends Mob {

	public Enemy(float positionX, float positionY, float directionX, float directionY, float width, float height, float health) {
		super(positionX, positionY, directionX, directionY, width, height, health);
	}
	public Enemy(float positionX, float positionY, float width, float height, float health) {
		super(positionX, positionY, width, height, health);
	}
	
}
