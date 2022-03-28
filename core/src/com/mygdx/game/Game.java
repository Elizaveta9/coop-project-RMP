package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.StateManager;

public class Game extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Шашки в москве";

	private StateManager stateManager;

	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		stateManager = new StateManager();
		ScreenUtils.clear(1, 0, 0, 1);
		stateManager.push(new MenuState(stateManager));
	}

	@Override
	public void render () {

		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
