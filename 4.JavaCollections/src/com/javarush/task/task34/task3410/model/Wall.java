package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(210, 105, 30));

        int xc = getX();
        int yc = getY();
        int height = getHeight();
        int width = getWidth();

        graphics.fillRect(xc - width / 2, yc - height / 2, width, height);
    }
}