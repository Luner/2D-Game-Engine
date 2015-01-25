package com.kulthro.games.game_engine;

public class Vector2f {

	private float x;
	private float y;
	
	public Vector2f(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2f add(Vector2f v){
		return new Vector2f(this.x + v.getX(), this.y + v.getY());
	}
	
	public Vector2f scale(float v){
		return new Vector2f(this.x * v, this.y * v);
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
}
