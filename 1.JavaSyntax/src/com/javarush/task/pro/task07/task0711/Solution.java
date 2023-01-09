package com.javarush.task.pro.task07.task0711;

/* 
Гибкое заполнение массива
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Integer[] array = new Integer[5];
        fillArray(array, 3, 1, 3);
        System.out.println(Arrays.toString(array));
    }

    public static void fillArray(Integer[] array, int value, int begin, int end) {
        for (int i = 0; i < array.length; i++) {
            if (begin > 0 && end < array.length) {
                for (int j = begin; j < end; j++) {
                    array[j] = value;
                }
            }
        }
    }
}
