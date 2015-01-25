package com.kulthro.games.game_engine.camera;

import com.kulthro.games.game_engine.Vector2f;

public class Camera {
	private Vector2f position;
	private Vector2f direction;
	
	public Camera () {
		this(0,0,0,0);
	}
	
	public Camera(float positionX, float positionY) {
		this(positionX, positionY, 0, 0);
	}
	
	public Camera(float positionX, float positionY, float directionX, float directionY) {
		position = new Vector2f(positionX,positionY);
		direction = new Vector2f(directionX,directionY);
	}
	
	private void move(){
		this.position = this.position.add(direction);
	}
	
	public void update(){
		move();
	}
}
