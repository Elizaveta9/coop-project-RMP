package com.mygdx.game.states;

/*
    Экран меню
 */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class MenuState extends State {

    private Texture background;
    private Texture newGameButton;
    private Texture changeSkinButton;
    private Texture logo;

    public MenuState(StateManager sm) {
        super(sm);
        background = new Texture("bg-road586x900.png");
        newGameButton = new Texture("new-game-button.png");
        changeSkinButton = new Texture("change-skin-button.png");
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
        batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        batch.draw(logo, (Game.WIDTH / 2) - (logo.getWidth() / 2), Game.HEIGHT - logo.getHeight()-20);
        batch.draw(newGameButton, (Game.WIDTH / 2) - (newGameButton.getWidth() / 2), Game.HEIGHT / 2);
        batch.draw(changeSkinButton, (Game.WIDTH / 2) - (changeSkinButton.getWidth() / 2), Game.HEIGHT/3);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        newGameButton.dispose();
        changeSkinButton.dispose();
        logo.dispose();
    }
}
