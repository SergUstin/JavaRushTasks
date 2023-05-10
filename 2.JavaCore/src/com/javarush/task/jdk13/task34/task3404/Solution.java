package com.javarush.task.jdk13.task34.task3404;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        if (numRings == 1) {
            System.out.printf("From %s to %s\n", a, b);
        } else {
            moveRing(a, b, c, numRings - 1);
            moveRing(a, b, c, numRings);
        }
    }
}