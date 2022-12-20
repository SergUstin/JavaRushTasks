package com.javarush.task.pro.task04.task0421;

/* 
Охлаждение ядра планеты
*/

public class Solution {
    public static void main(String[] args) {
        int number = 0;
        int sum = 0;

        while (number <= 100) {
            if (number % 2 == 0) {
                sum += number;
            }
            number++;
        }
        System.out.println(sum);
    }
}