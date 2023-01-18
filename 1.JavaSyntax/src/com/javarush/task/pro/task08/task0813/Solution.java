package com.javarush.task.pro.task08.task0813;

/* 
Степень двойки
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getPowerOfTwo(3));
    }

    public static int getPowerOfTwo(int power) {
        // int result = 2;
        // for(int i = 0; i < power - 1; i++) {
        //     result *= 2;
        // }
        return 2 << power - 1;
    }
}
