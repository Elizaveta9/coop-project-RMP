package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.StateManager;

import java.io.IOException;

public class Game extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Checkers in Moscow";

	private StateManager stateManager;

	SpriteBatch batch;
	BitmapFont font;

	@Override
	public void create () {
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter.color = Color.WHITE;
		fontParameter.size = 40;

		font = fontGenerator.generateFont(fontParameter);

		batch = new SpriteBatch();
		stateManager = new StateManager();
		ScreenUtils.clear(1, 0, 0, 1);
		stateManager.push(new MenuState(stateManager));
	}

	@Override
	public void render () {

		stateManager.update(Gdx.graphics.getDeltaTime());
		try {
			stateManager.render(batch, font);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
