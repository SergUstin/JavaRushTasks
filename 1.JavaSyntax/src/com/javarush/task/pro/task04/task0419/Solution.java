package com.javarush.task.pro.task04.task0419;

import java.util.Scanner;

/* 
Защита от землетрясения
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;



        if (number <= 0) {
            System.out.println(0);
        }else {
            while (number > 0) {
                sum += number;
                number--;
            }
            System.out.println(sum);
        }



    }
}