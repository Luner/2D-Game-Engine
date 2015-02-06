package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.util.Input;
import com.kulthro.games.game_engine.util.Vector2f;

public class ClassicControls extends Control{

	public ClassicControls(Entity controlling) {
		super(controlling);
	}
	
	public void update(){
		if(Input.getKey(Input.KEY_W)){
			this.moveY(-0.25f);
		}
		if(Input.getKey(Input.KEY_A)){
			this.moveX(-0.25f);
		}
		if(Input.getKey(Input.KEY_S)){
			this.moveY(0.25f);
		}
		if(Input.getKey(Input.KEY_D)){
			this.moveX(0.25f);
		}
		if(Input.getKeyDown(Input.KEY_SPACE)){
			this.setPosition(new Vector2f(this.getPosition().getX(), this.getPosition().getY() - 1));
			this.setYVelocity(-10f);
		}
		
	}
}
