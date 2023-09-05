package com.javarush.task.task30.task3010;

import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        String line = null;
        try {
            line = args[0];
            Pattern pattern = Pattern.compile("[^0-9A-Za-z]");
            if (pattern.matcher(line).find()) {
                System.out.println("incorrect");
            } else {
                char max = 0;
                char[] chars = line.toUpperCase().toCharArray();
                for (char current : chars) {
                    if (current > max) {
                        max = current;
                    }
                }
                int radix;
                if (max <= '9') {
                    radix = max - 47;
                } else {
                    radix = max - 54;
                }
                if (radix < 2) {
                    radix = 2;
                }
                System.out.println(radix);
            }
        } catch (Exception e) {
        }
    }
}
