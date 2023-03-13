package com.javarush.task.pro.task17.task1716;

/* 
Дорожное движение
*/

public interface Vehicle {
    default void start() {

    }

    void move();

    default void stop() {

    }
}
