package com.mygdx.game.states;

/*
    Экран концовки
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
import com.mygdx.game.Records;

import java.io.IOException;

public class EndState extends State {

    private Texture restartGameButton;
    private Texture newRecordImage;
    private Texture oldRecordImage;
    private String streetCar;
    private int newRecord;
    private int record;

    public EndState(StateManager sm, String streetCar, int record) {
        super(sm);
        this.streetCar = streetCar;
        this.newRecord = record;

        restartGameButton = new Texture("restart-game-button.png");
        newRecordImage = new Texture("new-record.png");
        oldRecordImage = new Texture("old-record.png");
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
                sm.set(new SkinState(sm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) throws IOException {
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        record  = Records.getRecords();
        if (newRecord > record) {
            Records.setRecords(newRecord);
            batch.draw(newRecordImage, (Game.WIDTH / 2) - (newRecordImage.getWidth() / 2 + 60), Game.HEIGHT - newRecordImage.getHeight() - 20);
        } else { batch.draw(oldRecordImage, (Game.WIDTH / 2) - (oldRecordImage.getWidth() / 2 + 60), Game.HEIGHT - oldRecordImage.getHeight() - 20);}
        batch.draw(restartGameButton, (Game.WIDTH / 2) - (restartGameButton.getWidth() / 2), Game.HEIGHT / 3);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        restartGameButton.dispose();
        newRecordImage.dispose();
        oldRecordImage.dispose();
    }
}
