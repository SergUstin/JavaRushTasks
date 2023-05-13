package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                while (numSeconds > 0) {
                    System.out.println(numSeconds);
                    Thread.sleep(1000);
                    numSeconds--;
                }
                System.out.println("Марш!");
            } catch (Exception e) {
                System.out.println("Прервано!");
            }
        }
    }
}
