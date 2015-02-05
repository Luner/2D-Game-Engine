package com.kulthro.games.game_engine.game;

import java.util.ArrayList;

import com.kulthro.games.game_engine.Render;
import com.kulthro.games.game_engine.Screen;
import com.kulthro.games.game_engine.entities.Entity;

public class Level {
	Environment environment;
	ArrayList<Entity> entities;

	public Level(Environment environment, ArrayList<Entity> entities){
		this.environment = environment;
		this.entities = entities;
	}
	
	private void render(){
		Screen.clearScreen();
		drawBackground();
		drawEntities();
	}
	
	private void drawEntities(){
		for(Entity e : entities) {
			Render.renderQuad(e.getPosition().getX(), e.getPosition().getY(), e.getPosition().getX() + e.getWidth(), e.getPosition().getY() + e.getHeight(), e.getTexture());
		}
	}
	
	public static void drawBackground() {
		Render.renderQuadVerticleGradient(0, 0, Screen.WIDTH, Screen.HEIGHT, 0.1f, 0.4f, 0.8f, 0.3f, 0.8f, 1f);
	}
	
	//To be fixed with collision
	public void update(){
		environment.update(entities);
		for(Entity entity : entities){
			for(Entity entity2 : entities){
				if(!entity.equals(entity2)){
					entity.isColliding(entity2);
				}
			}
			entity.update();
		}
		render();
	}
}
