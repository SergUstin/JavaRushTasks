package com.javarush.task.task24.task2413;

public class Stand extends BaseObject {
    //скорость
    private double speed;
    //направление (-1 влево, +1 вправо)
    private double direction;

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {
        double dx = speed * direction;
        x = x + dx;
    }

    /**
     * direction устанавливается равным -1
     */
    public void moveLeft() {
        direction = -1;
    }

    /**
     * direction устанавливается равным +1
     */
    public void moveRight() {
        direction = 1;
    }
}
