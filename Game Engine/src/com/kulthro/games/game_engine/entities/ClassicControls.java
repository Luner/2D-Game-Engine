package com.kulthro.games.game_engine.entities;

import com.kulthro.games.game_engine.util.Input;

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
			this.setYVelocity(-5f);
		}
		
	}
}
