package com.javarush.games.spaceinvaders.gameobjects;

public class Ship extends GameObject {
    public boolean isAlive = true;

    public Ship(double x, double y) {
        super(x, y);
    }

    public Bullet fire() {
        return null;
    }

    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
    }

    public void kill() {
        isAlive = false;
    }
}
