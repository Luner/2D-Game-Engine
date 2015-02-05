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
	
	//Renders the Level
	private void render(){
		Screen.clearScreen();
		drawBackground();
		drawEntities();
	}
	
	//Draws all of the Entities
	private void drawEntities(){
		for(Entity e : entities) {
			Render.renderQuad(e.getPosition().getX(), e.getPosition().getY(), e.getPosition().getX() + e.getWidth(), e.getPosition().getY() + e.getHeight(), e.getTexture());
		}
	}
	
	//Draws the Background
	public static void drawBackground() {
		Render.renderQuadVerticleGradient(0, 0, Screen.WIDTH, Screen.HEIGHT, 0.1f, 0.4f, 0.8f, 0.3f, 0.8f, 1f);
	}
	
	//To be Fixed With Collision
	public void update(){
		environment.update(entities);
		entities.get(1).isColliding(entities.get(0));
		for(Entity entity : entities) {
			entity.update();
		}
		render();
	}
}
