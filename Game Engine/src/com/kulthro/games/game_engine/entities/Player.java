package com.kulthro.games.game_engine.entities;

import org.lwjgl.util.vector.Vector2f;

public class Player extends Mob {

	public Player(float positionX, float positionY, float directionX, float directionY, float width, float height, float health) {
		super(positionX, positionY, directionX, directionY, width, height, health);
	}
	
	public Player(float positionX, float positionY, float width, float height, float health) {
		super(positionX, positionY, width, height, health);
	}
	
	public Player(Vector2f position, Vector2f direction, float width, float height, float health) {
		super(position.getX(),position.getY(),direction.getX(),direction.getY(),width,height,health);
	}
	
}
