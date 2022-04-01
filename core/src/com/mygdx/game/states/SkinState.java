package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class SkinState extends State {

    private Texture whiteSkinButton;
    private Texture pinkSkinButton;
    private Texture greenSkinButton;
    private Texture logo;
    private Sound carPickSound;

    public SkinState(StateManager sm) {
        super(sm);
        logo = new Texture("logo.png");
        whiteSkinButton = new Texture("whiteCar.png");
        greenSkinButton = new Texture("greenCar.png");
        pinkSkinButton = new Texture("pinkCar.png");
        carPickSound = Gdx.audio.newSound(Gdx.files.internal("carСhoice.mp3"));
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mouse);
            if ((mouse.x > (Game.WIDTH / 2) - (greenSkinButton.getWidth() / 2)) &&
                    (mouse.x < (Game.WIDTH / 2) + (greenSkinButton.getWidth() / 2)) &&
                    (mouse.y > (Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight())) &&
                    (mouse.y < (Game.HEIGHT - logo.getHeight() - 20))) {
                carPickSound.play(0.3f);
                sm.set(new PlayState(sm, "greenCar.png"));}}

        if (Gdx.input.justTouched()) {
            mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mouse);
            if ((mouse.x > (Game.WIDTH / 2) - (pinkSkinButton.getWidth() / 2)) &&
                    (mouse.x < (Game.WIDTH / 2) + (pinkSkinButton.getWidth() / 2)) &&
                    (mouse.y > (Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight() - 20 - pinkSkinButton.getHeight())) &&
                            (mouse.y < (Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight() - 20))) {
                carPickSound.play(0.3f);
                sm.set(new PlayState(sm, "pinkCar.png" ));}}

        if (Gdx.input.justTouched()) {
            mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mouse);
            if ((mouse.x > (Game.WIDTH / 2) - (whiteSkinButton.getWidth() / 2)) &&
                    (mouse.x < (Game.WIDTH / 2) + (whiteSkinButton.getWidth() / 2)) &&
                    (mouse.y > (Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight() - 20 - pinkSkinButton.getHeight() - 20 - whiteSkinButton.getHeight() )) &&
                    (mouse.y < (Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight() - 20 - pinkSkinButton.getHeight()) - 20)) {
                carPickSound.play(0.3f);
                sm.set(new PlayState(sm, "whiteCar.png"));}}
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
        batch.draw(logo, (Game.WIDTH / 2) - (logo.getWidth() / 2), Game.HEIGHT - logo.getHeight()-20);
        batch.draw(greenSkinButton, (Game.WIDTH / 2) - (greenSkinButton.getWidth() / 2),Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight());
        batch.draw(pinkSkinButton, (Game.WIDTH / 2) - (pinkSkinButton.getWidth() / 2),  Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight() - 20 - pinkSkinButton.getHeight());
        batch.draw(whiteSkinButton, (Game.WIDTH / 2) - (whiteSkinButton.getWidth() / 2), Game.HEIGHT - logo.getHeight() - 20 - greenSkinButton.getHeight() - 20 - pinkSkinButton.getHeight() - 20 - whiteSkinButton.getHeight());
        batch.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        greenSkinButton.dispose();
        logo.dispose();
        whiteSkinButton.dispose();
        pinkSkinButton.dispose();
    }
}
