package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.util.Input;
import com.kulthro.games.game_engine.util.Vector2f;

public class ClassicControls extends Control{

	public ClassicControls(Entity controlling, float speedLimit) {
		super(controlling);
	}
	
	public void update(){
		if(Input.getKey(Input.KEY_W)){
			this.setYVelocity(-4f);
		} else if(Input.getKey(Input.KEY_S)){
			this.setYVelocity(4f);
		}
		if(Input.getKey(Input.KEY_A)){
			this.setXVelocity(-4f);
		} else if(Input.getKey(Input.KEY_D)){
			this.setXVelocity(4f);
		} else {
			this.setXVelocity(0f);
		}
		if(Input.getKeyDown(Input.KEY_SPACE)){
			this.setPosition(new Vector2f(this.getPosition().getX(), this.getPosition().getY() - 1));
			this.setYVelocity(-10f);
		}
		
	}
}
