package com.kulthro.games.game_engine.game;

import java.util.ArrayList;

import com.kulthro.games.game_engine.entities.Entity;

public class Level {
	Environment environment;
	ArrayList<Entity> entities;

	public Level(Environment environment, ArrayList<Entity> entities){
		this.environment = environment;
		this.entities = entities;
	}

	public void update(){
		environment.update(entities);
		for(Entity entity : entities){
			entity.update();
		}
	}
}
