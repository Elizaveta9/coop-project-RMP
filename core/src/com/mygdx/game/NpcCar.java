package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class NpcCar extends Rectangle {

    private Texture npcCar;
    private Vector2 poseCar;
    private Random randomLine;
    private int xLine;
    public static int count;

    private static final int[] arrayLine = {140, 265, 375, 30,};

    public NpcCar(Texture car, float y) {
        this.npcCar = car;

        width = npcCar.getWidth();
        height = npcCar.getHeight();

        if (count <= 0) {
            randomLine = new Random();
            xLine = arrayLine[randomLine.nextInt(4)];
            poseCar = new Vector2(xLine, y);
            count=0;
        } else {
            randomLine = new Random();
            xLine = arrayLine[randomLine.nextInt(3)];
            poseCar = new Vector2(xLine, y);
        }
        count--;

    }

    public Texture getNpcCar() {
        return npcCar;
    }

    public void setNpcCar(Texture npcCar) {
        this.npcCar = npcCar;
    }

    public Vector2 getPoseNpcCar() {
        return poseCar;
    }

    public void setPoseCar(Vector2 poseCar) {
        this.poseCar = poseCar;
    }

    public void reposition(float y, Texture texture) {
        poseCar.set(arrayLine[randomLine.nextInt(4)], y);
        npcCar = texture;
    }


}
