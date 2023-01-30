package com.javarush.task.pro.task09.task0919;

/* 
Разворот строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Ходит кот задом наперед";
        System.out.println(string);
        System.out.println(reverseString(string));
    }

    public static String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();
        String str = stringBuilder.toString();
        return str;
    }
}
