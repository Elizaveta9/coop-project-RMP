package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.CarPicture;
import com.mygdx.game.Game;
import com.mygdx.game.NpcCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PlayState extends State {

    private String streetCar;
    private int record;
    private CarPicture car;
    private ArrayList<Texture> arrayTextureNpcCar;
    private Array<NpcCar> npcCarArray;
    private Random randomTexture;
    public static final int CAR_SPACING = 100;
    public static final int CAR_COUNT = 7;
    private Sound carCrash;

    private Vector2 backgroundPosition1, backgroundPosition2;


    public PlayState(StateManager sm, String streetCar) {
        super(sm);

        NpcCar.count = 3;

        try {
            carCrash = Gdx.audio.newSound(Gdx.files.internal("carCrash.mp3"));
            car = new CarPicture(streetCar);
            car.setPosition(new Vector3(car.getLine(), 20, 0));
            backgroundPosition1 = new Vector2(0, camera.position.y - camera.viewportHeight / 2);
            backgroundPosition2 = new Vector2(0, (camera.position.y - camera.viewportHeight / 2) + (background.getHeight() - 100));

        } catch (Exception e) {
            e.printStackTrace();
        }

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

        npcCarArray = new Array<NpcCar>();
        randomTexture = new Random();

        for (int i = 0; i < CAR_COUNT; i++) {
            npcCarArray.add(new NpcCar(arrayTextureNpcCar.get(randomTexture.nextInt(7)), i * (CAR_SPACING + 170)));
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
        updateBackground();
        car.move(dt);

        for (NpcCar npcCar : npcCarArray) {
            npcCar.x= npcCar.getPoseNpcCar().x;
            npcCar.y= npcCar.getPoseNpcCar().y;
            if (camera.position.y - (camera.viewportHeight / 2) > npcCar.getPoseNpcCar().y + npcCar.getNpcCar().getHeight()) {
                npcCar.reposition(npcCar.getPoseNpcCar().y + (170 + CAR_SPACING) * CAR_COUNT,
                        arrayTextureNpcCar.get(randomTexture.nextInt(7)));
            }

            if(car.overlaps(npcCar)){
                carCrash.play();
                sm.set(new EndState(sm, streetCar, 2));

            }

        }

        camera.position.y = car.getPosition().y + 380;
        camera.update();
    }

    @Override
    public void render(SpriteBatch batch, BitmapFont font) throws IOException {
        ScreenUtils.clear(78, 82, 85, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, backgroundPosition1.x, backgroundPosition1.y, Game.WIDTH, Game.HEIGHT);
        batch.draw(background, backgroundPosition2.x, backgroundPosition2.y, Game.WIDTH, Game.HEIGHT);
        for (NpcCar npcCar : npcCarArray) {
            batch.draw(npcCar.getNpcCar(), npcCar.getPoseNpcCar().x, npcCar.getPoseNpcCar().y);
        }
        batch.draw(car.getTexture(), car.getPosition().x, car.getPosition().y);
        batch.end();
    }

    @Override
    public void dispose() {

    }

    private void updateBackground() {
        if (camera.position.y - (camera.viewportHeight / 2) > backgroundPosition1.y + (background.getHeight() - 100)) {
            backgroundPosition1.add(0, (background.getHeight() - 100) * 2);
        }
        if (camera.position.y - (camera.viewportHeight / 2) > backgroundPosition2.y + (background.getHeight() - 100)) {
            backgroundPosition2.add(0, (background.getHeight() - 100) * 2);
        }
    }
}
