package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Sam", 3.0, 0.0));
        horseList.add(new Horse("Din", 3.0, 0.0));
        horseList.add(new Horse("Jim", 3.0, 0.0));
        game = new Hippodrome(horseList);
        
    }

    public void move() {}
    public void print() {}
    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
}
