package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        double median = getMedian(array);
        Arrays.sort(array, (o1, o2) -> {
            double res1 = o1 - median;
            double res2 = o2 - median;
            return (int) ((res1 * res1 - res2 * res2) * 100);
        });
        return array;
    }

    private static double getMedian(Integer[] array) {
        Arrays.sort(array);
        double result;

        if (array.length % 2 == 1) {
            result = array[array.length / 2];
        } else {
            result = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        }
        return result;
    }
}
