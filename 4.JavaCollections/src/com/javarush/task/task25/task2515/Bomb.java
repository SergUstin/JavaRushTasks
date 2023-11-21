package com.javarush.task.task25.task2515;

public class Bomb extends BaseObject {

    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'B');
    }

    @Override
    public void move() {
        y++;
    }
}
