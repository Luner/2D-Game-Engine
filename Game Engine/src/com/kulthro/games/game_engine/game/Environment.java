package com.kulthro.games.game_engine.game;

import java.util.ArrayList;

import com.kulthro.games.game_engine.entities.Entity;

public interface Environment {
	public void update(ArrayList<Entity> entities);
}
