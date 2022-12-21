package com.javarush.task.pro.task04.task0417;

import java.util.Scanner;

/* 
Скорость ветра
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int metersPerSecond = scanner.nextInt();

        double kilometersPerHour = 3.6;

        int res = (int) Math.round(metersPerSecond * kilometersPerHour);
        System.out.println(res);

    }
}