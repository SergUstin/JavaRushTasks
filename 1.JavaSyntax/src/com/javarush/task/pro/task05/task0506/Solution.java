package com.javarush.task.pro.task05.task0506;

import java.util.Arrays;
import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        array = new int[number];
        int min = 0;

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int tmp1 = array[j];
                if (tmp < tmp1) {
                    min = tmp1;
                }
            }
        }
        System.out.println(min);

        System.out.println(Arrays.toString(array));
    }
}
