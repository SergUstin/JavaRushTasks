package com.javarush.task.pro.task08.task0819;

import java.util.Random;

/* 
Амиголятор и Био-диего
*/

import static com.javarush.task.pro.task08.task0819.CosmicAnomaly.*;

public class Solution {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int num = random.nextInt(upperBound - lowerBound) + lowerBound;
            if (nextAttempt(num) == num) {
                break;
            }
        }
    }
}
