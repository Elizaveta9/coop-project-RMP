package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
        batch.begin();
        batch.draw(logo, (Game.WIDTH) - (logo.getWidth()), Game.HEIGHT - logo.getHeight() - 20);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
