package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Game;

import java.io.IOException;

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse; //должен быть Vector3, но он для 3D. Если что-то идёт не так, меняем обратно на Vector3
    protected StateManager sm;
    protected Texture background = new Texture("bg-road586x900.png");

    public State(StateManager sm){
        this.sm = sm;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Game.WIDTH, Game.HEIGHT);
        mouse = new Vector3();
    }

    //для опрашивания были ли нажаты каки-либо клавиши
    protected abstract void handleInput();

    //обновляет картинку
    public abstract void update(float dt);

    //рисует экран (SpriteBatch предоставляет координаты и текстуру для фигур)
    public abstract void render(SpriteBatch batch, BitmapFont font) throws IOException;

    //освобождает рисурсы
    public abstract void dispose();
}
