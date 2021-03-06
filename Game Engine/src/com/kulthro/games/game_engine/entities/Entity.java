package com.kulthro.games.game_engine.entities;

import org.newdawn.slick.opengl.Texture;

import com.kulthro.games.game_engine.util.Vector2f;

public abstract class Entity extends Quad{

	protected Vector2f direction;
	protected Texture tex;

	public Entity(Vector2f position, Vector2f direction, float width, float height) {
		super(position, width, height);
		this.direction = direction;
	}

	public Vector2f getDirection() {
		return direction;
	}

	public void setDirection(Vector2f direction) {
		this.direction = direction;
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

	//This Adds the Position to the Direction
	public void move() {
		this.position = this.position.add(direction);
	}


	public void isColliding(Entity quad){
		System.out.println(quad.getDirection().getX());
		if((quad.getPosition().getX() + quad.getWidth() >= this.position.getX() && quad.getPosition().getX() <= this.position.getX() + this.width)
				&& (quad.getPosition().getY() + quad.getHeight() >= this.getPosition().getY() + 1 && quad.getPosition().getY() <= this.position.getY() + this.height)){

			if((quad.getPosition().getY() + quad.getHeight() >= this.position.getY() && quad.getPosition().getY() <= this.position.getY() + this.height) && 
					!(quad.getPosition().getX() + quad.getWidth() <= this.getPosition().getX() + quad.getDirection().getX() )&& 
					!(quad.getPosition().getX() >= this.position.getX() + this.width + quad.getDirection().getX())){

				if(quad.getPosition().getY() + quad.getHeight() <= this.getPosition().getY() + this.height/2 /*Value may be wrong*/){
					//CollisionFromTop = true;
					//CollisionFromBottom = false;
					quad.setDirection(new Vector2f(quad.getDirection().getX(),0));
					quad.setPosition(new Vector2f (quad.getPosition().getX(), this.getPosition().getY() - quad.getHeight() + 1));
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
}
