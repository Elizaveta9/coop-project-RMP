package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;

public class PlayState extends State {

    private Texture logo;
    private String streetCar;
    private int record;

    public PlayState(StateManager sm, String streetCar) {
        super(sm);
        logo = new Texture("logo.png");

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            sm.set(new EndState(sm, streetCar, record));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(logo, (Game.WIDTH / 2) - (logo.getWidth() / 2), Game.HEIGHT - logo.getHeight() - 20);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
