package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int n = 10;
        while (n > 0) {
            int m = 20;
            while (m > 0) {
                if (n == 1 || n == 10) {
                    System.out.print("Б");
                } else if (m == 1 || m == 20) {
                    System.out.print("Б");
                } else {
                    System.out.print(" ");
                }
                m--;
            }
            System.out.println();
            n--;
        }


    }
}