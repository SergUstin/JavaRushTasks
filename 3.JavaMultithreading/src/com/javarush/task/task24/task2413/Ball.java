package com.javarush.task.task24.task2413;

public class Ball extends BaseObject {

    //скорость
    private double speed;
    //направление  (в градусах от 0 до 360)
    private double direction;

    //текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;

    //заморожен ли объект или может двигаться
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {

    }
}
