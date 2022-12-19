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
        int sum = 0;
        String text = "ENTER";

        while (scanner.hasNextInt()) {
            sum += count;
        }

        if (stop.equalsIgnoreCase(text)) {
            System.out.println(sum);
        }







        /*if (!stop.equalsIgnoreCase("ENTER")) {
            sum += count;
            System.out.println(sum);
        } else {
            while (!stop.equalsIgnoreCase("ENTER")) {
                count++;
            }
        }*/


    }
}