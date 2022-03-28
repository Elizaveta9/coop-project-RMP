package com.mygdx.game.states;

/*
    Экран концовки
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class EndState extends State {
    private Texture background;
    private Texture restartGameButton;
    private Texture newRecord;
    private Texture oldRecord;

    public EndState(StateManager sm) {
        super(sm);
        background = new Texture("bg-road586x900.png");
        restartGameButton = new Texture("restart-game-button.png");
        newRecord = new Texture("new-record.png");
        oldRecord = new Texture("old-record.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
        mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(mouse);
        if ((mouse.x > (Game.WIDTH / 2) - (restartGameButton.getWidth() / 2)) &&
                (mouse.x < (Game.WIDTH / 2) + (restartGameButton.getWidth() / 2)) &&
                (mouse.y > (Game.HEIGHT / 3)) &&
                (mouse.y < (Game.HEIGHT / 3) + restartGameButton.getHeight())) {
            sm.set(new PlayState(sm)); //сюда вместо PlayState(sm) вставить класс окна выбора скина
        }
    }
}

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        batch.draw(newRecord, (Game.WIDTH / 2) - (newRecord.getWidth() / 2), Game.HEIGHT - newRecord.getHeight() - 20);
        batch.draw(restartGameButton, (Game.WIDTH / 2) - (restartGameButton.getWidth() / 2), Game.HEIGHT / 3);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        restartGameButton.dispose();
        newRecord.dispose();
        oldRecord.dispose();
    }
}
