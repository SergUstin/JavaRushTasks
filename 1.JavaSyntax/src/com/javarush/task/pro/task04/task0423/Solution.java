package com.javarush.task.pro.task04.task0423;

import java.util.Scanner;

/* 
Калибровка климата
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int res = 0;

        for (int i = 0; i < 5 ; i++) {
            int number = scanner.nextInt();
            sum += number;
            res = sum / 5;

        }
        System.out.println(res);

    }
}
