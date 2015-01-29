package com.kulthro.games.game_engine;

import com.kulthro.games.game_engine.util.Vector2f;

public class Quad{

	protected Vector2f position;
	protected Vector2f direction;
	protected float width;
	protected float height;

	public Quad(Vector2f position, Vector2f direction, float width, float height) {
		this.position = position;
		this.direction = direction;
		this.width = width;
		this.height = height;
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

	public void isColliding(Quad quad){
		boolean collisionX = false;
		boolean collisionY = false;
		boolean collision = false;
		if(this.getPosition().getX() <= quad.getPosition().getX() + quad.getWidth() && this.position.getX() + this.getWidth() > quad.getPosition().getX()
				&& this.getPosition().getY() <= quad.getPosition().getY() + quad.getHeight() && this.position.getY() + this.getHeight() > quad.getPosition().getY()){
			collision = true;
		}

		if(collision){
			if(collisionY){
				quad.setDirection(new Vector2f(this.getDirection().getX(),0));
				if(this.getPosition().getY() < quad.getPosition().getY()){
					quad.setPosition(new Vector2f (quad.getPosition().getX() , this.getPosition().getY() + this.getHeight()));	
				} else {
					quad.setPosition(new Vector2f (quad.getPosition().getX() , this.getPosition().getY() - this.getHeight()));	
				}
			}
			if(collisionX){
				quad.setDirection(new Vector2f(0,this.getDirection().getY()));
				if(this.getPosition().getX() < quad.getPosition().getX()){
					quad.setPosition(new Vector2f (this.getPosition().getX() + quad.getWidth(), quad.getPosition().getY()));	
				} else {
					quad.setPosition(new Vector2f (this.getPosition().getX() - this.getWidth(), quad.getPosition().getY()));	
				}
				System.out.println("X-collision");
			}
		}
	}
}
