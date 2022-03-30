package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;

/*
координаты x для полос дороги:
    1 -
        110
    2 -
        125
    3 -
        110
    4 -
 */

public class PlayState extends State {

    private Texture logo;
    private String streetCar;
    private int record = 0;
    private Texture carTexture;

    public PlayState(StateManager sm, String streetCar) {
        super(sm);
        logo = new Texture("logo.png");
        carTexture = new Texture(streetCar);
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
        batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        batch.draw(carTexture, 100 - carTexture.getWidth() + 345, 20);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
