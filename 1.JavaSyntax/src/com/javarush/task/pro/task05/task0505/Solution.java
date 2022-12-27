package com.javarush.task.pro.task05.task0505;

import java.util.Arrays;
import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arrays = new int[number];

        if (number > 0) {
            for (int i = 0; i < number; i++) {
                arrays[i] = scanner.nextInt();
            }
        }

        if (number % 2 != 0) {
            for (int i = 0; i < arrays.length; i++) {
                System.out.println(arrays[i]);
            }
        } else {
            for (int i = arrays.length - 1; i >= 0 ; i--) {
                System.out.println(arrays[i]);
            }
        }

        /*

        if (number % 2 != 0) {
            System.out.println(Arrays.toString(arrays));
        } else {
            int[] temp = new int[arrays.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arrays[arrays.length - 1 - i];
            }
            System.out.println(Arrays.toString(temp));
        }

         */
    }
}
