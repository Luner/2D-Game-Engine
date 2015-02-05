package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.util.Vector2f;

public class Control {
	
	private Entity controlling;
	
	public Control(Entity controlling){
		this.controlling = controlling;
	}
	
	public void setEntity(Entity toControl){
		this.controlling = toControl;
	}
	
	public void moveY(float amount){
		controlling.setDirection(controlling.getDirection().add(new Vector2f(0,amount)));
	}
	
	public void moveX(float amount){
		controlling.setDirection(controlling.getDirection().add(new Vector2f(amount,0)));
	}
	
	public void setYVelocity(float yVelocity){
		controlling.setDirection(new Vector2f(controlling.getDirection().getX(), yVelocity));
	}
	
	public void setXVelocity(float xVelocity){
		controlling.setDirection(new Vector2f(xVelocity, controlling.getDirection().getY()));
	}
}
