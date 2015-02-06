package com.kulthro.games.game_engine.game;

import java.util.ArrayList;

import com.kulthro.games.game_engine.Render;
import com.kulthro.games.game_engine.Screen;
import com.kulthro.games.game_engine.entities.Block;
import com.kulthro.games.game_engine.entities.Entity;

public class Level {

	Environment environment;
	ArrayList<Entity> entities;
	ArrayList<Block> blocks;

	public Level(Environment environment, ArrayList<Entity> entities, ArrayList<Block> blocks){
		this.environment = environment;
		this.entities = entities;
		this.blocks = blocks;
	}

	//Renders the Level
	private void render(){
		Screen.clearScreen();
		drawBackground();
		drawBlocks();
		drawEntities();
	}

	//Draws all of the Entities
	private void drawEntities(){
		for(Entity e : entities) {
			Render.renderQuad(e.getPosition().getX(), e.getPosition().getY(), e.getPosition().getX() + e.getWidth(), e.getPosition().getY() + e.getHeight(), e.getTexture());
		}
	}

	private void drawBlocks(){
		for(Block b : blocks){
			Render.renderQuad(b.getPosition().getX(), b.getPosition().getY(), b.getPosition().getX() + b.getWidth(), b.getPosition().getY() + b.getHeight(), b.getTexture());
		}
	}

	//Draws the Background
	public static void drawBackground() {
		Render.renderQuadVerticleGradient(0, 0, Screen.WIDTH, Screen.HEIGHT, 0.1f, 0.4f, 0.8f, 0.3f, 0.8f, 1f);
	}

	//To be Fixed With Collision
	public void update(){
		environment.update(entities);
		for(Entity entity : entities) {
			for(Block block : blocks){
				block.isColliding(entity);;
			}
			entity.update();
		}
		render();
	}
}
