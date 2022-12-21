package com.javarush.task.pro.task04.task0418;

import java.util.Scanner;

/* 
Стакан наполовину пуст или наполовину полон?
*/

public class Solution {
    public static void main(String[] args) {
        double glass = 0.5;
        Scanner scanner = new Scanner(System.in);
        boolean name = scanner.nextBoolean();
        int res = 0;

        if (name) {
            res = (int) Math.ceil(glass);
        } else {
            res = (int) Math.floor(glass);
        }

        System.out.println(res);


    }
}