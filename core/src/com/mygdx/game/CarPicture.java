package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class CarPicture extends Rectangle {
    private Texture texture;
    private int line;
    private Map<Integer, Integer> linesX = new HashMap<>();

    public CarPicture(String texture) {
        try {
            this.texture = new Texture(texture);

            linesX.put(1, 30);
            linesX.put(2, 140);
            linesX.put(3, 265);
            linesX.put(4, 375);

            line = 1;
        } catch (Exception e){
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
}
