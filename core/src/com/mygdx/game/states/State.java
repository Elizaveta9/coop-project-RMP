package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector2 mouse; //должен быть Vector3, но он для 3D. Если что-то идёт не так, меняем обратно на Vector3
    protected StateManager sm;

    public State(StateManager sm){
        this.sm = sm;
        camera = new OrthographicCamera();
        mouse = new Vector2();
    }

    //для опрашивания были ли нажаты каки-либо клавиши
    protected abstract void handleInput();

    //обновляет картинку
    public abstract void update(float dt);

    //рисует экран (SpriteBatch предоставляет координаты и текстуру для фигур)
    public abstract void render(SpriteBatch batch);

    //освобождает рисурсы
    public abstract void dispose();
}