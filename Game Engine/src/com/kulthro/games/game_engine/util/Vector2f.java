package com.kulthro.games.game_engine.util;

public class Vector2f {

	private float x;
	private float y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f add(Vector2f vector) {
		return new Vector2f(this.x + vector.getX(), this.y + vector.getY());
	}
	
	public Vector2f scale(float scale) {
		return new Vector2f(this.x * scale, this.y * scale);
	}
	
	public Vector2f multiply(Vector2f vector){
		return new Vector2f(this.x * vector.getX(), this.y * vector.getY());
	}
	
	public void setVector(Vector2f vector){
		this.x = vector.getX();
		this.y = vector.getY();
	}
	
	public void setVector(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
}
