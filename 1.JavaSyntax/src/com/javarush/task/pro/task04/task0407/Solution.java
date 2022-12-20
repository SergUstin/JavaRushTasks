package com.javarush.task.pro.task04.task0407;

/* 
Сумма чисел, не кратных 3
*/

public class Solution {
    public static void main(String[] args) {
        int index = 0;
        int sum = 0;

        while (index < 100) {
            index++;
            if ( index % 3 == 0) {
                continue;
            }
            sum += index;
        }

        System.out.println(sum);


    }
}