package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.CarPicture;
import com.mygdx.game.Game;
import com.mygdx.game.NpcCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PlayState extends State {

    private static final int countNpcCar = 3;

    private String streetCar;
    private int record;
    private CarPicture car;
    private ArrayList<Texture> arrayTextureNpcCar;
    private Array<NpcCar> npcCarArray;
    private Random randomTexture;



    public PlayState(StateManager sm, String streetCar) {

        super(sm);

        Texture npcAbobusCar = new Texture("npcAbobusCar.png");
        Texture npcMedCar = new Texture("npcMedCar.png");
        Texture npcOrangeCar = new Texture("npcOrangeCar.png");
        Texture npcPoliceCar = new Texture("npcPoliceCar.png");
        Texture npcradCar = new Texture("npcradCar.png");
        Texture npcTaxiCar = new Texture("npcTaxiCar.png");
        Texture npcYellowCar = new Texture("npcyellowCar.png");
        arrayTextureNpcCar = new ArrayList<Texture>();
        arrayTextureNpcCar.add(npcAbobusCar);
        arrayTextureNpcCar.add(npcMedCar);
        arrayTextureNpcCar.add(npcOrangeCar);
        arrayTextureNpcCar.add(npcYellowCar);
        arrayTextureNpcCar.add(npcradCar);
        arrayTextureNpcCar.add(npcPoliceCar);
        arrayTextureNpcCar.add(npcTaxiCar);

        car = new CarPicture(streetCar);
        car.x = car.getLine();
        car.y = 20;

        npcCarArray = new Array<NpcCar>();
        randomTexture = new Random();

        for (int i = 0; i < countNpcCar; i++ ){
            npcCarArray.add(new NpcCar(arrayTextureNpcCar.get(randomTexture.nextInt(6))));
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
    public void render(SpriteBatch batch, BitmapFont font) throws IOException {
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
