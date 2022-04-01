package com.mygdx.game.states;

/*
    Экран концовки
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.Records;

import java.io.IOException;

public class EndState extends State {

    private Texture restartGameButton;
    private Texture newRecordImage;
    private Texture oldRecordImage;
    private Sound tapSound;
    private int score;
    private int record;
    private String recordString;
    private String scoreString;

    public EndState(StateManager sm, int record) {
        super(sm);
        this.score = record;

        restartGameButton = new Texture("restart-game-button.png");
        newRecordImage = new Texture("new-record.png");
        oldRecordImage = new Texture("old-record.png");
        tapSound = Gdx.audio.newSound(Gdx.files.internal("buttonClick.mp3"));
        recordString = Integer.toString(record);
        scoreString = Integer.toString(score);
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
                tapSound.play(0.3f);
                sm.set(new SkinState(sm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch, BitmapFont font) throws IOException {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        record = Records.getRecords();
        recordString = Integer.toString(record);

        scoreString = Integer.toString(score);

        if (score > record) {
            Records.setRecords(score);
            font.draw(batch, scoreString, 380, 630);
            batch.draw(newRecordImage, (Game.WIDTH / 2) - (newRecordImage.getWidth() / 2 + 60), Game.HEIGHT - newRecordImage.getHeight() - 20);
        } else {
            batch.draw(oldRecordImage, (Game.WIDTH / 2) - (oldRecordImage.getWidth() / 2 + 60), Game.HEIGHT - oldRecordImage.getHeight() - 20);
            font.draw(batch, scoreString, 380, 720);
            font.draw(batch, recordString, 380, 630);
        }
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
