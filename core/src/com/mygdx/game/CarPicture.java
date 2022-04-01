package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;

public class CarPicture extends Rectangle {
    private static final int speed = 400;
    private Texture texture;
    private int line;
    private Map<Integer, Integer> linesX;
    private Boolean isMoving;
    private char direction;
    private Vector3 position;

    public CarPicture(String texture) {
        try {
            this.texture = new Texture(texture);
            width = this.texture.getWidth();
            height = this.texture.getHeight();
            isMoving = false;

            direction = 'r';

            linesX = new HashMap<>();

            linesX.put(1, 30);
            linesX.put(2, 140);
            linesX.put(3, 265);
            linesX.put(4, 375);

            line = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getLine() {
        return linesX.get(line);
    }

    public Integer getRightLine() {
        line += 1;
        if (line > 4) {
            line = 4;
        }
        return linesX.get(line);
    }

    public Integer getLeftLine() {
        line -= 1;
        if (line < 1) {
            line = 1;
        }
        return linesX.get(line);
    }

    public void goRight() {
        isMoving = true;
        direction = 'r';
        line += 1;
        if (line > 4) {
            line = 4;
        }
    }

    public void goLeft() {
        isMoving = true;
        direction = 'l';
        line -= 1;
        if (line < 1) {
            line = 1;
        }
    }

    public void move(float dt) {

        position.add(0, speed * dt, 0);

        if (isMoving == true) {
            switch (direction) {
                case 'r':
                    if (position.x < linesX.get(line)) {
                        position.x += 600 * Gdx.graphics.getDeltaTime();
                    } else {
                        isMoving = false;
                        position.x = linesX.get(line); // машину потрясывает из-за этой линии
                    }
                    break;

                case 'l':
                    if (position.x > linesX.get(line)) {
                        position.x -= 600 * Gdx.graphics.getDeltaTime();
                    } else {
                        isMoving = false;
                        position.x = linesX.get(line); // машину потрясывает из-за этой линии тоже
                        // но если эти линии убрать то машина постепенно будет смещаться с центра линий
                    }
                    break;
            }
        }
        x = position.x;
        y = position.y;
    }
}
