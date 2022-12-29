package com.javarush.task.pro.task05.task0511;

import java.util.Arrays;
import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        multiArray = new int[a][];

        for (int i = 0; i < multiArray.length; i++) {
            multiArray[i] = new int[scanner.nextInt()];
        }

        for (int j = 0; j < multiArray.length; j++) {
            for (int i = 0; i < multiArray[j].length; i++) {
                System.out.print("[]");
            }
            System.out.println();
        }
    }
}
