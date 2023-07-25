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

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Sam", 3.0, 0.0));
        horseList.add(new Horse("Din", 3.0, 0.0));
        horseList.add(new Horse("Jim", 3.0, 0.0));
        game = new Hippodrome(horseList);
        game.run();
    }

    public void move() {
        for (Horse hors : horses) {
            hors.move();
        }
    }
    public void print() {
        for (Horse hors : horses) {
            hors.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);            
        }
    }

    public Horse getWinner() {
        Horse result = horses.get(0);
        for (Horse hors : horses) {
            if (hors.getDistance() > result.getDistance()) {
                result = hors;
            }
        }
        return result;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
