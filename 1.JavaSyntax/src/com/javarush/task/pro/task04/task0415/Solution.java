package com.javarush.task.pro.task04.task0415;

import java.util.Scanner;

/* 
Площадь круга
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radius = scanner.nextInt();

        double pi = 3.14;
        int S = (int) (pi* radius * radius);

        System.out.println(S);

        /*
        double S = Math.PI * radius * radius;
        radius = (int) Math.floor(S);

        System.out.println(radius);
         */

    }
}