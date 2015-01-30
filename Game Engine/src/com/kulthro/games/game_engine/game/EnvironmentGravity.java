package com.kulthro.games.game_engine.game;

import java.util.ArrayList;

import com.kulthro.games.game_engine.entities.Entity;
import com.kulthro.games.game_engine.util.Vector2f;

public class EnvironmentGravity implements Environment{
	
	float gravity;
	public EnvironmentGravity(float gravity){
		this.gravity = gravity;
	}
	
	public void update(ArrayList<Entity> entities){
		for(Entity entity : entities){
			entity.setDirection(entity.getDirection().add(new Vector2f(0,gravity)));
		}
	}
}
