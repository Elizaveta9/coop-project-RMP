package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class CarPicture extends Rectangle {
    private Texture texture;
    private int line;
    private Map<Integer, Integer> linesX;
    private Boolean isMoving;
    private char direction;

    public CarPicture(String texture) {
        try {
            this.texture = new Texture(texture);

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

    public void move() {
        if (isMoving == true){
            switch (direction){
                case 'r':
                    if (x < linesX.get(line)){
                        x += 600 * Gdx.graphics.getDeltaTime();
                    } else {
                        isMoving = false;
                        x = linesX.get(line); // машину потрясывает из-за этой линии
                    }
                    break;

                case 'l':
                    if (x > linesX.get(line)){
                        x -= 600 * Gdx.graphics.getDeltaTime();
                    } else {
                        isMoving = false;
                        x = linesX.get(line); // машину потрясывает из-за этой линии тоже
                                            // но если эти линии убрать то машина постепенно будет смещаться с центра линий
                    }
                    break;
            }
        }


        }
    }
