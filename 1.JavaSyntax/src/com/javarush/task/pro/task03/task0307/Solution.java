package com.javarush.task.pro.task03.task0307;

import java.util.Scanner;

/* 
Работать или не работать - вот в чем вопрос
*/

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int age = s.nextInt();
        boolean isYang = age >= 20;
        boolean isOld = age <= 60;

        if (!isYang || !isOld)
        System.out.println("можно не работать");
    }
}
