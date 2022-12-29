package com.javarush.task.pro.task05.task0507;

import java.util.Arrays;
import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        System.out.println(array[array.length - 1]);
    }
}
