package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MIN_VALUE;
        int secondMin = 0;

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (min < num) {
                min = num;
            } else if (secondMin < num) {
                secondMin = num;
                //if (min < secondMin)
            }
        }
        System.out.println(min);
        System.out.println(secondMin);

    }
}