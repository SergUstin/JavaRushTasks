package com.javarush.task.pro.task05.task0529;

import java.util.Arrays;

/* 
Галаксианские роботанки (1)
*/

public class Solution {
    public static String robotank = "☖";
    public static String empty = "_";
    public static String hit = "🎯";

    public static int width = 30;

    public static int height = 10;

    public static String[][] field = new String[height * width][];

    public static void main(String[] args) {
        for (int i = 0; i < field.length; i++) {
             Arrays.fill(field[i], empty);
            System.out.println(Arrays.deepToString(field));
        }
    }
}
