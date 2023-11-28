package com.javarush.task.task34.task3410.model;

import java.awt.*;

abstract public class GameObject {
    protected int x;
    protected int y;
    protected int width = Model.FIELD_CELL_SIZE;
    protected int height = Model.FIELD_CELL_SIZE;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    abstract public void draw(Graphics graphics);
}