package com.javarush.task.pro.task18.task1806;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

/* 
Знакомство с foreach
*/

public class Solution {
    public static void main(String[] args) {
        var numbers = new ArrayList<Integer>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        print(numbers);
    }

    public static void print(ArrayList<Integer> numbers) {
        numbers.forEach(number -> System.out.println(number));
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }
    }
}
