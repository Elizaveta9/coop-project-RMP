package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.CarPicture;
import com.mygdx.game.Game;

public class PlayState extends State {

    private String streetCar;
    private int record;
    private CarPicture car;


    public PlayState(StateManager sm, String streetCar) {
        super(sm);
        try {
            car = new CarPicture(streetCar);
            car.x = car.getLine();
            car.y = 20;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void handleInput() {

        if (Gdx.input.justTouched()) {
            mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mouse);
            if (mouse.x > (Game.WIDTH / 2)) {
                car.goRight();
            }
        }

        if (Gdx.input.justTouched()) {
            mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mouse);
            if (mouse.x < (Game.WIDTH / 2)) {
                car.goLeft();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        car.move();
    }

    @Override
    public void render(SpriteBatch batch) {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        batch.draw(car.getTexture(), car.x, car.y);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
