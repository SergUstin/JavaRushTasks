package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stop = scanner.nextLine();
        int count = scanner.nextInt();
        String text = "ENTER";
        int sum = 0;

        while (!stop.equalsIgnoreCase(text)) {
            sum += count;
        }
        System.out.println(sum);

    }
}