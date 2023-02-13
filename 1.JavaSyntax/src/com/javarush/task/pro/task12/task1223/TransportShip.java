package com.javarush.task.pro.task12.task1223;

public class TransportShip {
    public Integer speed;
    public Integer acceleration;
    public Passenger[] passengers;
    public OnBoardSystem onBoardSystem = new OnBoardSystem();

    public class OnBoardSystem {
        public Integer calculateJumpTime(Integer distance) {
            int s = 0;
            int t = 0;
            while (s < distance) {
                t++;
                s = (speed * t) + (acceleration * t * t / 2);
            }
            return t - 1;
        }
    }
}
