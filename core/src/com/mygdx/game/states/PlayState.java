package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;

public class PlayState extends State {

    private Texture logo;

    public PlayState(StateManager sm) {
        super(sm);
        logo = new Texture("logo.png");

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

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