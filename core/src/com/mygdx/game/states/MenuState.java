package com.mygdx.game.states;

/*
    Экран меню
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class MenuState extends State {

    private Texture newGameButton;
    private Texture logo;
    private Sound tapSound;
    private Music music;

    public MenuState(StateManager sm) {
        super(sm);
        newGameButton = new Texture("new-game-button.png");
        logo = new Texture("logo.png");
        tapSound = Gdx.audio.newSound(Gdx.files.internal("buttonClick.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mouse);
            if ((mouse.x > (Game.WIDTH / 2) - (newGameButton.getWidth() / 2)) &&
                    (mouse.x < (Game.WIDTH / 2) + (newGameButton.getWidth() / 2)) &&
                    (mouse.y > (Game.HEIGHT / 3)) &&
                    (mouse.y < (Game.HEIGHT / 3) + newGameButton.getHeight())) {
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
    public void render(SpriteBatch batch, BitmapFont font) {
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        batch.draw(logo, (Game.WIDTH / 2) - (logo.getWidth() / 2), Game.HEIGHT - logo.getHeight() - 20);
        batch.draw(newGameButton, (Game.WIDTH / 2) - (newGameButton.getWidth() / 2), Game.HEIGHT / 3);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        newGameButton.dispose();
        logo.dispose();
    }
}
