package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int secondMin = scanner.nextInt();

        if (min > secondMin) {
            int tmp = min;
            min = secondMin;
            secondMin = tmp;

        }

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (min == secondMin && num > secondMin) {
                secondMin = num;
            } else if (num < min) {
                secondMin = min;
                min = num;
            } else if (num > min && num < secondMin) {
                secondMin = num;
            }
        }

        System.out.println(secondMin);

    }
}