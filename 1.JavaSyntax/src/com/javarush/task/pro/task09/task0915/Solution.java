package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] array = new String[stringTokenizer.countTokens()];
        for (int i = 0; i < array.length; i++) {
            while (stringTokenizer.hasMoreTokens()) {
                array[i] = stringTokenizer.nextToken();
                i++;
            }
        }
        return array;
    }
}
