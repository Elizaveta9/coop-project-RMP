package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.IOException;
import java.util.Stack;

/*
    Класс для управления состояниями или окнами
    (сущесвует два состояния: игра и пауза)
 */
public class StateManager {

    private Stack<State> states;

    public StateManager() {
        states = new Stack<State>();
    }

    //помещает элемент в вершину стека
    public void push(State state){
        states.push(state);
    }

    //извоекает верхний элемент и удаляет из стека
    public void pop(){
        states.pop().dispose();
    }

    //извлекает верхний и помещает новый
    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    //обновляет текущее состояние (экран)
    public void update(float dt){
        states.peek().update(dt);
    }

    //отрисовывает текущее состояние (экран)
    public void render(SpriteBatch batch) throws IOException {
        states.peek().render(batch);
    }


}
