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

	//This Collision is Completely Broken and Will be Worked on After the Cleaning Up is Done
	public void isColliding(Quad quad){
		if((quad.getPosition().getX() + quad.getWidth() >= this.position.getX() && quad.getPosition().getX() <= this.position.getX() + this.width)
				&& (quad.getPosition().getY() + quad.getHeight() >= this.getPosition().getY() + 1 && quad.getPosition().getY() <= this.position.getY() + this.height)){
			if((quad.getPosition().getY() + quad.getHeight() >= this.position.getY() && quad.getPosition().getY() <= this.position.getY() + this.height) && 
					(!(quad.getPosition().getX() + quad.getWidth() <= this.getPosition().getX() + this.getDirection().getX()))&& !(quad.getPosition().getX() >= this.position.getX() + this.width + /*This may be a -*/ this.getDirection().getX())){
				if(quad.getPosition().getY() + quad.getHeight() <= this.getPosition().getY() + this.height/2 /*Value may be wrong*/){
					//CollisionFromTop = true;
					//CollisionFromBottom = false;
					quad.setDirection(new Vector2f(quad.getDirection().getX(),0));
					quad.setPosition(new Vector2f (quad.getPosition().getX(), this.getPosition().getY() - quad.getHeight()));
					System.out.println("CollisionFromTop");
				}
				else{
					//CollisionFromTop = false;
					//CollisionFromBottom = true;
					quad.setDirection(new Vector2f(quad.getDirection().getX(),0));
					quad.setPosition(new Vector2f (quad.getPosition().getX(), this.getPosition().getY() + quad.getHeight()));
					System.out.println("CollisionFromBottom");
				}
			}
			else if(quad.getPosition().getX() + quad.getWidth() >= this.getPosition().getX() && quad.getPosition().getX() <= this.position.getX() + this.width){
				if(quad.getPosition().getX() + quad.getWidth() <= this.position.getX() + this.width / 2 /*Value may be Wrong*/){
					//CollisionFromRight = true;
					//CollisionFromLeft = false;
					quad.setDirection(new Vector2f(0,quad.getDirection().getY()));
					quad.setPosition(new Vector2f (this.getPosition().getX() - quad.getWidth(), quad.getPosition().getY()));
					System.out.println("CollisionFromLeft");
				}
				else{
					//CollisionFromRight = false;
					//CollisionFromLeft = true;
					quad.setDirection(new Vector2f(0,quad.getDirection().getY()));
					quad.setPosition(new Vector2f (this.getPosition().getX() + quad.getWidth(), quad.getPosition().getY()));
					System.out.println("CollisionFromRight");
				
				}
			}
		}	
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

	//This Adds the Position to the Direction
	public void move() {
		this.position = this.position.add(direction);
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float area() {
		return this.width * this.height;
	}
}
